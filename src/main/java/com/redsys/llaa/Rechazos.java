/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redsys.llaa;

import com.redsys.llaa.model.Ip0040;
import com.redsys.llaa.model.S4bmcint;
import com.redsys.llaa.model.S4bmcintPK;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Long.parseLong;

/**
 *
 * @author S3316AM
 */
public class Rechazos {
//Hola
    private static final Logger log = LoggerFactory.getLogger(Rechazos.class);
    private static final String IP40_FILE ="C:/temp/ibm/RBIP40Q0.TXT";
    private static final String TANDEM_SQL = "S4BMCINT_INSERT.SQL";
    private static final String TARJETAS = "TARJETAS.TXT";
    
    private static EntityManagerFactory emf;

    private static PrintWriter out;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String linea = "";
        
        try {
            log.info("AUSOL Operaciones rechazadas....");

            emf = Persistence.createEntityManagerFactory("llaaH2");

//            loadIP0040();
            
            out = new PrintWriter(new BufferedWriter(new FileWriter(TANDEM_SQL)));            
            try(BufferedReader in = new BufferedReader(new FileReader(TARJETAS))){
                while((linea = in.readLine()) !=  null){
                    buscarRango(linea);
                }
            }

            emf.close();
            out.close();

            log.info("fin.");
        } catch (IOException ex) {
            log.error("ERROR FICHEROS!!!", ex);
        }
    }

  

    private static void loadIP0040() {

        log.info("Inicio loadIP0040....");
        
        String reg = "";

        try {

            try (BufferedReader reader = new BufferedReader(new FileReader(new File(IP40_FILE)))) {
                borrarIP0040();
                
                log.info("createIP0040....");
                while ((reg = reader.readLine()) != null) {
                    createIP0040(reg);                     
                }
            }
        } catch (IOException e) {
            log.error("ERROR GRAVE !!!!", e);
        }
        
        log.info("Fin loadIP0040.");

    }

    private static Ip0040 createIP0040(String reg) {

        Ip0040 ip0040 = new Ip0040();

        ip0040.setDatefile(reg.substring(0, 10));
        ip0040.setRanmen(reg.substring(19, 38));
        ip0040.setIdprod(reg.substring(38, 41));
        ip0040.setRanmay(reg.substring(41, 60));
        
        ip0040.setCodact(reg.substring(10, 11));
        ip0040.setTabla(reg.substring(11, 19));
        ip0040.setAcepbrand(reg.substring(60, 63));
        ip0040.setAcbrprio(new Short(reg.substring(63, 65)));
        ip0040.setMbrid(new Long(reg.substring(65, 76)));
        ip0040.setTipoprod(new Short(reg.substring(76, 77)));
        ip0040.setEndpoint(new Integer(reg.substring(77, 84)));
        ip0040.setIndformat(reg.substring(84, 85));
        ip0040.setPaisalfa(reg.substring(85, 88));
        ip0040.setPaisnum(new Short(reg.substring(88, 91)));
        ip0040.setRegion(reg.substring(91, 92));
        ip0040.setMoneda(new Short(reg.substring(92, 95)));
        ip0040.setExponente(new Short(reg.substring(95, 96)));
        ip0040.setOccursMonedas(reg.substring(96, 124));
        ip0040.setFiller(reg.substring(124, 125));
        ip0040.setRouting(reg.substring(125, 126));
        ip0040.setReassw(reg.substring(126, 127));
        ip0040.setPaypass(reg.substring(127, 128));
        ip0040.setClaseprod(reg.substring(128, 131));

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(ip0040);
        em.getTransaction().commit();

        em.close();
        
        return ip0040;
    }

    private static void buscarRango(String tarjeta) {

    	if(tarjeta.length() == 8)
           tarjeta = tarjeta.concat("00000001");
    	
    	if(tarjeta.length() == 9)
           tarjeta = tarjeta.concat("0000001");
    	
        log.info("TARJETA:{}", tarjeta);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        
        List<Ip0040> list = em.createNamedQuery("Ip0040.findByRango",Ip0040.class)
                              .setParameter("ranmen", tarjeta)
                              .setParameter("ranmay", tarjeta)
                              .getResultList();
        
        if (list.isEmpty()) {
            log.error("NO EXISTE!!! {}", tarjeta);
        } else {
       	    taskTandem(em, list.get(0));
        }

        em.getTransaction().commit();
        em.close();

    }

	private static void taskTandem(EntityManager em, Ip0040 ip0040) {
		S4bmcintPK id = new S4bmcintPK(ip0040.getRanmay(), ip0040.getRanmen(), (short) 0); 
		S4bmcint s4bmcint = em.find(S4bmcint.class, id);
		
		if(s4bmcint == null){
		   s4bmcint = insertS4bmcint(ip0040); 
		} 
		
		if(s4bmcint != null){
		    saveTandem(s4bmcint,"0");
		    saveTandem(s4bmcint,"1");
		}
	}

    private static S4bmcint insertS4bmcint(Ip0040 ip0040) {

        log.info("insert S4bmcint...");
        
        EntityManager em = emf.createEntityManager();

        S4bmcintPK pK = new S4bmcintPK(ip0040.getRanmay(), ip0040.getRanmen(), (short) 0);
        S4bmcint s4bmcint = new S4bmcint(pK);
        
        long r1 = parseLong(ip0040.getRanmay());
        long r2 = parseLong(ip0040.getRanmen());
        String lbin = Long.toString(r1 - r2);

        //alf 2021-03-23
        int count9s = 0;
        byte[] bs = lbin.getBytes();
        for (int i = 0; i < bs.length; i++) {
            if('9' == bs[i]){                
                count9s++;
            }
            
        }
        //alf 2021-03-23
//        s4bmcint.setLongBin((short) (19 - lbin.length()));
        s4bmcint.setLongBin((short) (19 - count9s));

        s4bmcint.setMarcaMaster(ip0040.getAcepbrand());
        s4bmcint.setTipoTarjeMaster(ip0040.getIdprod());
        s4bmcint.setIdentifMiembro(ip0040.getMbrid());
        s4bmcint.setTipoProduMaster(ip0040.getTipoprod().toString());
        s4bmcint.setEndpoint(ip0040.getEndpoint());
        s4bmcint.setCodPaisMaster(ip0040.getPaisalfa());
        s4bmcint.setCodPaisMasterNum(ip0040.getPaisnum());
        s4bmcint.setRegionMas(ip0040.getRegion());
        s4bmcint.setCodMonMas(ip0040.getMoneda());
        s4bmcint.setExpCodMon(ip0040.getExponente());
        s4bmcint.setClaseProducto("A");
        s4bmcint.setIndRutaTrans(ip0040.getRouting());
        s4bmcint.setIndReasignarProdu(ip0040.getReassw());
        
        String fechaMod = new SimpleDateFormat("yyyyMMdd").format(new Date());
//        String fechaMod = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        s4bmcint.setFechaModific(new Integer(fechaMod));
        
        s4bmcint.setIndCashback("N");
        s4bmcint.setIndReasigFirstPre("N");
        s4bmcint.setIndPaypass(ip0040.getPaypass());
        s4bmcint.setIndLevelParti("N");
        s4bmcint.setFechaActivLevelParti(0);
        s4bmcint.setTipoTarjetaHp((short) tipo_tarjeta(ip0040));
        s4bmcint.setMarcaTarjetaHp((short) 5);

        em.getTransaction().begin();
        em.persist(s4bmcint);
        em.getTransaction().commit();

        em.close();

        return s4bmcint;
    }

    private static int tipo_tarjeta(Ip0040 ip0040) {
        int w_tipo_tarj = 0;

        String ip40_tipo_tarje_master = ip0040.getIdprod();
        String ip40_region_mas = ip0040.getRegion();
        String ip40_marca_master = ip0040.getAcepbrand();

        if ((ip40_tipo_tarje_master.equals("MCG")
                || ip40_tipo_tarje_master.equals("MDG")
                || ip40_tipo_tarje_master.equals("MDP")
                || ip40_tipo_tarje_master.equals("MPL"))
                && ip40_region_mas.equals("D")) {
            w_tipo_tarj = 57;
        } else if ((ip40_tipo_tarje_master.equals("MCG")
                || ip40_tipo_tarje_master.equals("MDG")
                || ip40_tipo_tarje_master.equals("MDP")
                || ip40_tipo_tarje_master.equals("MPL"))
                && !ip40_region_mas.equals("D")) {
            w_tipo_tarj = 59;
        } else if (ip40_marca_master.equals("CIR") && ip40_region_mas.equals("D")) {
            w_tipo_tarj = 75;
        } else if (ip40_marca_master.equals("CIR") && !ip40_region_mas.equals("D")) {
            w_tipo_tarj = 81;
        } else if (ip40_marca_master.equals("MSI") && ip40_region_mas.equals("D")) {
            w_tipo_tarj = 76;
        } else if (ip40_marca_master.equals("MSI") && !ip40_region_mas.equals("D")) {
            w_tipo_tarj = 82;
        } else if ((ip40_marca_master.equals("MCC") || ip40_marca_master.equals("DMC"))
                && ip40_region_mas.equals("D")) {
            w_tipo_tarj = 71;
        } else if ((ip40_marca_master.equals("MCC")
                || ip40_marca_master.equals("DMC"))
                && !ip40_region_mas.equals("D")) {
            w_tipo_tarj = 73;
        } else if (ip40_marca_master.equals("MAV")
                || ip40_marca_master.equals("PRO")
                || ip40_marca_master.equals("PVL")
                || ip40_marca_master.equals("SOL")
                || ip40_marca_master.equals("SWI")
                || ip40_marca_master.equals("VIS")) {
            w_tipo_tarj = 0;
        } else {
            w_tipo_tarj = 0;
        }

        return w_tipo_tarj;
    }

    private static void borrarIP0040() {
        
        log.info("borrando IP0040...");
        
        EntityManager em = emf.createEntityManager();        
        
        em.getTransaction().begin();
        
        Query q = em.createQuery("delete from Ip0040");
        int deletes = q.executeUpdate();
        log.warn( "deletes IP0040! = {}",deletes);
        
        em.getTransaction().commit();

        em.close();
        
        log.info("borrado IP0040!");
    }

    private static void saveTandem(S4bmcint s4bmcint, String codProceso) {
        
        log.info("saveTandem {}",codProceso+ " -> "+ s4bmcint.getS4bmcintPK().getBinRangoInferior());
        
        S4bmcintPK s4bmcintPK = s4bmcint.getS4bmcintPK();
        
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO =S4BMCINT VALUES (");
        builder.append(System.lineSeparator());
        
        builder.append("'");builder.append(s4bmcintPK.getBinRangoSuperior());builder.append("'");
        builder.append(",");
        
        builder.append("'");builder.append(s4bmcintPK.getBinRangoInferior());builder.append("'");
        builder.append(",");
        
        builder.append(codProceso);
        builder.append(",");
        
        builder.append(s4bmcint.getLongBin());
        builder.append(",");
        
        builder.append("'");builder.append(s4bmcint.getMarcaMaster());builder.append("'");
        builder.append(",");
        
        builder.append("'");builder.append(s4bmcint.getTipoTarjeMaster());builder.append("'");
        builder.append(",");
        
        builder.append(System.lineSeparator());
        
        builder.append(s4bmcint.getIdentifMiembro());
        builder.append(",");
        
        builder.append("'");builder.append(s4bmcint.getTipoProduMaster());builder.append("'");
        builder.append(",");
        
        builder.append(s4bmcint.getEndpoint());
        builder.append(",");
        
        builder.append("'");builder.append(s4bmcint.getCodPaisMaster());builder.append("'");
        builder.append(",");
        
        builder.append(s4bmcint.getCodPaisMasterNum());
        builder.append(",");
        
        builder.append("'");builder.append(s4bmcint.getRegionMas());builder.append("'");
        builder.append(",");
        
        builder.append(s4bmcint.getCodMonMas());
        builder.append(",");
        
        builder.append(s4bmcint.getExpCodMon());
        builder.append(",");
        
        builder.append("'");builder.append(s4bmcint.getClaseProducto());builder.append("'");
        builder.append(",");
        
        builder.append("'");builder.append(s4bmcint.getIndRutaTrans());builder.append("'");
        builder.append(",");
        
        builder.append("'");builder.append(s4bmcint.getIndReasignarProdu());builder.append("'");
        builder.append(",");
        
        
//        String fechaMod = new SimpleDateFormat("yyyyMMdd").format(new Date());
//        String fechaMod = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        builder.append(s4bmcint.getFechaModific());
        builder.append(",");
        
        builder.append(System.lineSeparator());
        
        builder.append("'");builder.append(s4bmcint.getIndCashback());builder.append("'");
        builder.append(",");
        
        builder.append("'");builder.append(s4bmcint.getIndReasigFirstPre());builder.append("'");
        builder.append(",");
        
        builder.append("'");builder.append(s4bmcint.getIndPaypass());builder.append("'");
        builder.append(",");
        
        builder.append("'");builder.append(s4bmcint.getIndLevelParti());builder.append("'");
        builder.append(",");
                
        builder.append(s4bmcint.getFechaActivLevelParti());
        builder.append(",");
        
        builder.append(s4bmcint.getTipoTarjetaHp());
        builder.append(",");
        
        builder.append(s4bmcint.getMarcaTarjetaHp());        
        builder.append(");");
        builder.append(System.lineSeparator());
        
        out.println(builder.toString());
    }

    
}
