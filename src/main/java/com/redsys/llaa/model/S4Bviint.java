package com.redsys.llaa.model;
/**
  RANGO_SUPERIOR                 CHAR(9) NO DEFAULT                      NOT NULL
, RANGO_INFERIOR                 CHAR(9) NO DEFAULT                      NOT NULL
, LONG_BIN                       DECIMAL( 2, 0 ) DEFAULT 06              NOT NULL
, REGION_VISA                    DECIMAL( 1, 0 ) DEFAULT SYSTEM          NOT NULL
, TIPO_TARJE_VISA                CHAR(1) DEFAULT SYSTEM                  NOT NULL
, BIN_EMISO                      CHAR(6) DEFAULT SYSTEM                  NOT NULL
, BIN_PROCE                      CHAR(6) DEFAULT SYSTEM                  NOT NULL
, LONGITUD_PAN                   DECIMAL( 2, 0 ) DEFAULT SYSTEM          NOT NULL
, TIPO_CHECK                     CHAR(2) DEFAULT SYSTEM                  NOT NULL
, CODIGO_MONEDA                  CHAR(3) DEFAULT SYSTEM                  NOT NULL
, CODIGO_PAIS                    CHAR(3) DEFAULT SYSTEM                  NOT NULL
, CODIGO_VISA                    CHAR(2) DEFAULT SYSTEM                  NOT NULL
, DOMINIO                        CHAR(1) DEFAULT SYSTEM                  NOT NULL
, USO                            CHAR(1) DEFAULT SYSTEM                  NOT NULL
, TIPO_TARJETA                   DECIMAL( 4, 0 ) DEFAULT SYSTEM          NOT NULL
, FECHA_MODIFIC                  DECIMAL( 8, 0 ) DEFAULT SYSTEM          NOT NULL
, INDIC_CHIP                     CHAR(1) DEFAULT SYSTEM                  NOT NULL
, REGION_VISA_ISSUER             DECIMAL( 1, 0 ) DEFAULT SYSTEM          NOT NULL
, CODIGO_PAIS_VISA_ISSUER        CHAR(2) DEFAULT SYSTEM                  NOT NULL
, PRODUCT_ID                     CHAR(2) DEFAULT SYSTEM                  NOT NULL
, TIPO_TARJETA_HP                DECIMAL( 4, 0 ) UNSIGNED DEFAULT SYSTEM NOT NULL
, MARCA_TARJETA_HP               DECIMAL( 3, 0 ) UNSIGNED DEFAULT SYSTEM NOT NULL
*/

public class S4Bviint {
	  private String rangoSuperior;         
	  private String rangoInferior;         
	  private String longBin;               
	  private String regionVisa;            
	  private String tipoTarjeVisa;        
	  private String binEmiso;              
	  private String binProce;              
	  private String longitudPan;           
	  private String tipoCheck;             
	  private String codigoMoneda;          
	  private String codigoPais;            
	  private String codigoVisa;            
	  private String dominio;                
	  private String uso;                    
	  private String tipoTarjeta;           
	  private String fechaModific;          
	  private String indicChip;             
	  private String regionVisaIssuer;     
	  private String codigoPaisVisaIssuer;
	  private String productId;             
	  private String tipoTarjetaHp;        
	  private String marcaTarjetaHp;       

	public S4Bviint() {
		
	}

	public String getRangoSuperior() {
		return rangoSuperior;
	}

	public void setRangoSuperior(String rangoSuperior) {
		this.rangoSuperior = rangoSuperior;
	}

	public String getRangoInferior() {
		return rangoInferior;
	}

	public void setRangoInferior(String rangoInferior) {
		this.rangoInferior = rangoInferior;
	}

	public String getLongBin() {
		return longBin;
	}

	public void setLongBin(String longBin) {
		this.longBin = longBin;
	}

	public String getRegionVisa() {
		return regionVisa;
	}

	public void setRegionVisa(String regionVisa) {
		this.regionVisa = regionVisa;
	}

	public String getTipoTarjeVisa() {
		return tipoTarjeVisa;
	}

	public void setTipoTarjeVisa(String tipoTarjeVisa) {
		this.tipoTarjeVisa = tipoTarjeVisa;
	}

	public String getBinEmiso() {
		return binEmiso;
	}

	public void setBinEmiso(String binEmiso) {
		this.binEmiso = binEmiso;
	}

	public String getBinProce() {
		return binProce;
	}

	public void setBinProce(String binProce) {
		this.binProce = binProce;
	}

	public String getLongitudPan() {
		return longitudPan;
	}

	public void setLongitudPan(String longitudPan) {
		this.longitudPan = longitudPan;
	}

	public String getTipoCheck() {
		return tipoCheck;
	}

	public void setTipoCheck(String tipoCheck) {
		this.tipoCheck = tipoCheck;
	}

	public String getCodigoMoneda() {
		return codigoMoneda;
	}

	public void setCodigoMoneda(String codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getCodigoVisa() {
		return codigoVisa;
	}

	public void setCodigoVisa(String codigoVisa) {
		this.codigoVisa = codigoVisa;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public String getFechaModific() {
		return fechaModific;
	}

	public void setFechaModific(String fechaModific) {
		this.fechaModific = fechaModific;
	}

	public String getIndicChip() {
		return indicChip;
	}

	public void setIndicChip(String indicChip) {
		this.indicChip = indicChip;
	}

	public String getRegionVisaIssuer() {
		return regionVisaIssuer;
	}

	public void setRegionVisaIssuer(String regionVisaIssuer) {
		this.regionVisaIssuer = regionVisaIssuer;
	}

	public String getCodigoPaisVisaIssuer() {
		return codigoPaisVisaIssuer;
	}

	public void setCodigoPaisVisaIssuer(String codigoPaisVisaIssuer) {
		this.codigoPaisVisaIssuer = codigoPaisVisaIssuer;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTipoTarjetaHp() {
		return tipoTarjetaHp;
	}

	public void setTipoTarjetaHp(String tipoTarjetaHp) {
		this.tipoTarjetaHp = tipoTarjetaHp;
	}

	public String getMarcaTarjetaHp() {
		return marcaTarjetaHp;
	}

	public void setMarcaTarjetaHp(String marcaTarjetaHp) {
		this.marcaTarjetaHp = marcaTarjetaHp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("S4Bviint [rangoSuperior=");
		builder.append(rangoSuperior);
		builder.append(", rangoInferior=");
		builder.append(rangoInferior);
		builder.append(", longBin=");
		builder.append(longBin);
		builder.append(", regionVisa=");
		builder.append(regionVisa);
		builder.append(", tipoTarjeVisa=");
		builder.append(tipoTarjeVisa);
		builder.append(", binEmiso=");
		builder.append(binEmiso);
		builder.append(", binProce=");
		builder.append(binProce);
		builder.append(", longitudPan=");
		builder.append(longitudPan);
		builder.append(", tipoCheck=");
		builder.append(tipoCheck);
		builder.append(", codigoMoneda=");
		builder.append(codigoMoneda);
		builder.append(", codigoPais=");
		builder.append(codigoPais);
		builder.append(", codigoVisa=");
		builder.append(codigoVisa);
		builder.append(", dominio=");
		builder.append(dominio);
		builder.append(", uso=");
		builder.append(uso);
		builder.append(", tipoTarjeta=");
		builder.append(tipoTarjeta);
		builder.append(", fechaModific=");
		builder.append(fechaModific);
		builder.append(", indicChip=");
		builder.append(indicChip);
		builder.append(", regionVisaIssuer=");
		builder.append(regionVisaIssuer);
		builder.append(", codigoPaisVisaIssuer=");
		builder.append(codigoPaisVisaIssuer);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", tipoTarjetaHp=");
		builder.append(tipoTarjetaHp);
		builder.append(", marcaTarjetaHp=");
		builder.append(marcaTarjetaHp);
		builder.append("]");
		return builder.toString();
	}

	
}
