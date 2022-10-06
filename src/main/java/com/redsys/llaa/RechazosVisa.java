package com.redsys.llaa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redsys.llaa.model.S4Bviint;
import com.redsys.llaa.model.db2.T86Pais;
import com.redsys.llaa.model.db2.Te3MonedaPais;

public class RechazosVisa {

	private static final Logger log = LoggerFactory.getLogger(RechazosVisa.class);	
	private static final String[] RACTRNG=
		{
//       "R400450999   20200331 400450000   400450116  411797W5BR A5BR       NF YD       C   Y", 
//	     "R486876087   20220518 486876087   448233116Y 400088W1US  1US      AAF  Y       D",
//	     "R442301895   20211123 442301895   472437116Y 454605W4AU A4AU       NN1         C   Y",
//	     "R486876188   20220518 486876188   459661116Y 456933W3GB A3GB        I  Y       D   Y",
//	     "R408116277   20211012 408116218   459425116Y 488249W5CO  5CO        P          C   Y",
	     "R486752005   20220518 486752000   474477116Y 438599W1US  1US      AAF  Y       D"
		};
	
	private static final String TANDEM_SQL = "INSVIINT.TXT";
	private static final String ACTRNG_FILE ="C:/temp/ibm/VISA_ACTRNG.TXT";
	private static final String VLACTRNG_FILE ="C:/temp/ibm/VLACTRNG.TXT";
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Connection connection = null;
	private PrintWriter out;

	
	public RechazosVisa() {
		log.info("AUSOL VISA Operaciones rechazadas....");
		
		try {
//			emf = Persistence.createEntityManagerFactory("dsnpPU");
//			em = emf.createEntityManager();
//			getCodigoMonedaJPA(getCodigoPaisJPA("ES"));
			
			connection = getConnection();
			out = new PrintWriter(new BufferedWriter(new FileWriter(TANDEM_SQL)));
			
//			extract();
			
			for (int i = 0; i < RACTRNG.length; i++) {
				create(extract(RACTRNG[i]));
			}
			
//			em.close();
//			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
			out.close();
		}

		log.info("Fin.....");
	}

	private Connection getConnection(){
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:db2://cpud.redsys.es:8300/DSNO","WASDSND2","24rh971r");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}	
		
		return connection;
	}
	
	private void closeConnection(){
		try {
			if(connection != null)
			   connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private S4Bviint extract(String RACTRNG) throws Exception {
		S4Bviint s4Bviint = new S4Bviint();
		
		s4Bviint.setRangoSuperior(RACTRNG.substring(1,10));         
		s4Bviint.setRangoInferior(RACTRNG.substring(22,31));         
		s4Bviint.setLongBin("6");               
		s4Bviint.setRegionVisa(RACTRNG.substring(52,53));            
		s4Bviint.setTipoTarjeVisa(RACTRNG.substring(79,80));     
		s4Bviint.setBinEmiso(RACTRNG.substring(34,40));              
		s4Bviint.setBinProce(RACTRNG.substring(45,51));              
		s4Bviint.setLongitudPan("16");           
		s4Bviint.setTipoCheck("01");
		s4Bviint.setCodigoVisa(RACTRNG.substring(53,55));
		
		int codigoPais = getCodigoPais(s4Bviint.getCodigoVisa());		
		s4Bviint.setCodigoPais(String.format("%03d", codigoPais));
		
		int codigoMoneda = getCodigoMoneda(codigoPais);
		s4Bviint.setCodigoMoneda(String.format("%03d", codigoMoneda));
		
		s4Bviint.setDominio(RACTRNG.substring(51,52));                
		s4Bviint.setUso(s4Bviint.getTipoTarjeVisa());                    
		s4Bviint.setTipoTarjeta(s4Bviint.getRegionVisa().equals("3") ? "61" : "64");           
		s4Bviint.setFechaModific(new SimpleDateFormat("yyyyMMdd").format(new Date()));          
		s4Bviint.setIndicChip("A");             
		s4Bviint.setRegionVisaIssuer(s4Bviint.getRegionVisa());     
		s4Bviint.setCodigoPaisVisaIssuer(s4Bviint.getCodigoVisa());
		s4Bviint.setProductId(RACTRNG.substring(68,69));           
		s4Bviint.setTipoTarjetaHp(s4Bviint.getTipoTarjeta());        
		s4Bviint.setMarcaTarjetaHp("4");       

		log.info(s4Bviint.toString());
		
		return s4Bviint;
	}

	private int getCodigoPais(String pais) throws Exception{
		int codigo = 0;
		
		String sql = "SELECT * FROM GRUDES.T86S3 WHERE C86CALF2 = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, pais);
		
		ResultSet rset = pstmt.executeQuery();
		while(rset.next()){
			codigo = rset.getInt(1);
			log.info("CodigoPais="+codigo);
		}
		rset.close();		
		pstmt.close();
		
		return codigo;
	}
	
	private int getCodigoPaisJPA(String pais) throws Exception{
		T86Pais t86 = em.createQuery("SELECT t FROM T86Pais t WHERE t.c86calf2 = :pais",T86Pais.class)
				        .setParameter("pais", pais)
				        .getSingleResult();
		
		log.info(t86.toString());
		
		return t86.getC86lpais();
	}
	
	private int getCodigoMonedaJPA(int pais) throws Exception{
		
		Te3MonedaPais te3 = em.createQuery("SELECT t from Te3MonedaPais t where t.id.c86lpais= :pais",Te3MonedaPais.class)
		                      .setParameter("pais", pais)
		                      .getSingleResult();
		
		log.info(te3.toString());
		
		return te3.getId().getCe0lmone();
	}
	
	private int getCodigoMoneda(int pais) throws Exception{
		int codigo = 0;
		
		String sql = "SELECT * from GRUDES.TE3S4 where c86lpais= ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, pais);
		
		ResultSet rset = pstmt.executeQuery();
		while(rset.next()){
			codigo = rset.getInt(1);
			log.info("CodigoMoneda="+codigo);
		}
		rset.close();		
		pstmt.close();
		
		return codigo;
	}
/*
 INSERT INTO =S4BVIINT VALUES
 ("486876087"  --RANGO_SUPERIOR
 ,"486876087"  --RANGO_INFERIOR
 ,9            --LONG_BIN
 ,1            --REGION_VISA
 ,"D"          --TIPO_TARJE_VISA
 ,"448233"     --BIN_EMISO
 ,"400088"     --BIN_PROCE
 ,16           --LONGITUD_PAN
 ,"01"         --TIPO_CHECK
 ,"840"        --CODIGO_MONEDA
 ,"840"        --CODIGO_PAIS
 ,"US"         --CODIGO_VISA
 ,"W"          --DOMINIO
 ,"D"          --USO
 ,64           --TIPO_TARJETA
 ,20220920     --FECHA_MODIFIC
 ,"A"          --INDIC_CHIP
 ,1            --REGION_VISA_ISSUER
 ,"US"         --CODIGO_PAIS_VISA_ISSUER
 ,"1"          --PRODUCT_ID
 ,64           --TIPO_TARJETA_HP
 ,4            --MARCA_TARJETA_HP
 );
 */
	private void create(S4Bviint s4Bviint) {
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO =S4BVIINT VALUES");builder.append(System.lineSeparator());
		builder.append("('");builder.append(s4Bviint.getRangoSuperior());builder.append("'");//builder.append(System.lineSeparator());
		builder.append(",'");builder.append(s4Bviint.getRangoInferior());builder.append("'");//builder.append(System.lineSeparator());
		builder.append(",");builder.append(s4Bviint.getLongBin());builder.append("");//builder.append(System.lineSeparator());
		builder.append(",");builder.append(s4Bviint.getRegionVisa());builder.append("");//builder.append(System.lineSeparator());
		builder.append(",'");builder.append(s4Bviint.getTipoTarjeVisa());builder.append("'");//builder.append(System.lineSeparator());
		builder.append(",'");builder.append(s4Bviint.getBinEmiso());builder.append("'");//builder.append(System.lineSeparator());
		builder.append(",'");builder.append(s4Bviint.getBinProce());builder.append("'");builder.append(System.lineSeparator());
		builder.append(",");builder.append(s4Bviint.getLongitudPan());builder.append("");//builder.append(System.lineSeparator());
		builder.append(",'");builder.append(s4Bviint.getTipoCheck());builder.append("'");//builder.append(System.lineSeparator());
		builder.append(",'");builder.append(s4Bviint.getCodigoMoneda());builder.append("'");//builder.append(System.lineSeparator());
		builder.append(",'");builder.append(s4Bviint.getCodigoPais());builder.append("'");//builder.append(System.lineSeparator());
		builder.append(",'");builder.append(s4Bviint.getCodigoVisa());builder.append("'");//builder.append(System.lineSeparator());
		builder.append(",'");builder.append(s4Bviint.getDominio());builder.append("'");//builder.append(System.lineSeparator());
		builder.append(",'");builder.append(s4Bviint.getUso());builder.append("'");//builder.append(System.lineSeparator());
		builder.append(",");builder.append(s4Bviint.getTipoTarjeta());builder.append("");builder.append(System.lineSeparator());
		builder.append(",");builder.append(s4Bviint.getFechaModific());builder.append("");//builder.append(System.lineSeparator());
		builder.append(",'");builder.append(s4Bviint.getIndicChip());builder.append("'");//builder.append(System.lineSeparator());
		builder.append(",");builder.append(s4Bviint.getRegionVisaIssuer());builder.append("");//builder.append(System.lineSeparator());
		builder.append(",'");builder.append(s4Bviint.getCodigoPaisVisaIssuer());builder.append("'");//builder.append(System.lineSeparator());
		builder.append(",'");builder.append(s4Bviint.getProductId());builder.append("'");//builder.append(System.lineSeparator());
		builder.append(",");builder.append(s4Bviint.getTipoTarjetaHp());builder.append("");//builder.append(System.lineSeparator());
		builder.append(",");builder.append(s4Bviint.getMarcaTarjetaHp());builder.append("");//builder.append(System.lineSeparator());
		builder.append(");");
		
		out.println(builder);
		
		log.info("TANDEM\n"+builder.toString());
	}

	private void extract(){
		String linea = "";
		String typeRec = "VLACTRNG  R";
		try{
			try(BufferedReader in = new BufferedReader(new FileReader(ACTRNG_FILE))){
			    try(PrintWriter   out = new PrintWriter(new BufferedWriter(new FileWriter(VLACTRNG_FILE)))){
			    	while((linea = in.readLine()) !=  null){
			    		int of = linea.indexOf(typeRec);
			    		if(of > -1)
			    			out.println(linea.substring(of + typeRec.length() - 1));	
			    	}
                }
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {
		new RechazosVisa();
	}

	
}
