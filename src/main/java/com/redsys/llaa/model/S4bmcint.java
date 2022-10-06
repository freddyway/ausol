/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redsys.llaa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author S3316AM
 */
@Entity
@Table(name = "S4BMCINT")
@NamedQueries({
      @NamedQuery(name = "S4bmcint.findAll", query = "SELECT s FROM S4bmcint s")    
    , @NamedQuery(name = "S4bmcint.findByBinRangoCodProceso", query = "SELECT s FROM S4bmcint s WHERE s.s4bmcintPK.binRangoSuperior = :binRangoSuperior and s.s4bmcintPK.binRangoInferior = :binRangoInferior and s.s4bmcintPK.codProceso = :codProceso")
    , @NamedQuery(name = "S4bmcint.findByBinRango", query = "SELECT s FROM S4bmcint s WHERE s.s4bmcintPK.binRangoSuperior >= :binRangoSuperior and s.s4bmcintPK.binRangoInferior <= :binRangoInferior")
    , @NamedQuery(name = "S4bmcint.findByBinRangoSuperior", query = "SELECT s FROM S4bmcint s WHERE s.s4bmcintPK.binRangoSuperior = :binRangoSuperior")
    , @NamedQuery(name = "S4bmcint.findByBinRangoInferior", query = "SELECT s FROM S4bmcint s WHERE s.s4bmcintPK.binRangoInferior = :binRangoInferior")
    })
public class S4bmcint implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected S4bmcintPK s4bmcintPK;
    @Basic(optional = false)
    @Column(name = "LONG_BIN", nullable = false)
    private short longBin;
    @Basic(optional = false)
    @Column(name = "MARCA_MASTER", nullable = false, length = 3)
    private String marcaMaster;
    @Basic(optional = false)
    @Column(name = "TIPO_TARJE_MASTER", nullable = false, length = 3)
    private String tipoTarjeMaster;
    @Basic(optional = false)
    @Column(name = "IDENTIF_MIEMBRO", nullable = false)
    private long identifMiembro;
    @Basic(optional = false)
    @Column(name = "TIPO_PRODU_MASTER", nullable = false, length = 1)
    private String tipoProduMaster;
    @Basic(optional = false)
    @Column(name = "ENDPOINT", nullable = false)
    private int endpoint;
    @Basic(optional = false)
    @Column(name = "COD_PAIS_MASTER", nullable = false, length = 3)
    private String codPaisMaster;
    @Basic(optional = false)
    @Column(name = "COD_PAIS_MASTER_NUM", nullable = false)
    private short codPaisMasterNum;
    @Basic(optional = false)
    @Column(name = "REGION_MAS", nullable = false, length = 1)
    private String regionMas;
    @Basic(optional = false)
    @Column(name = "COD_MON_MAS", nullable = false)
    private short codMonMas;
    @Basic(optional = false)
    @Column(name = "EXP_COD_MON", nullable = false)
    private short expCodMon;
    @Basic(optional = false)
    @Column(name = "CLASE_PRODUCTO", nullable = false, length = 1)
    private String claseProducto;
    @Basic(optional = false)
    @Column(name = "IND_RUTA_TRANS", nullable = false, length = 1)
    private String indRutaTrans;
    @Basic(optional = false)
    @Column(name = "IND_REASIGNAR_PRODU", nullable = false, length = 1)
    private String indReasignarProdu;
    @Basic(optional = false)
    @Column(name = "FECHA_MODIFIC", nullable = false)
    private int fechaModific;
    @Basic(optional = false)
    @Column(name = "IND_CASHBACK", nullable = false, length = 1)
    private String indCashback;
    @Basic(optional = false)
    @Column(name = "IND_REASIG_FIRST_PRE", nullable = false, length = 1)
    private String indReasigFirstPre;
    @Basic(optional = false)
    @Column(name = "IND_PAYPASS", nullable = false, length = 1)
    private String indPaypass;
    @Basic(optional = false)
    @Column(name = "IND_LEVEL_PARTI", nullable = false, length = 1)
    private String indLevelParti;
    @Basic(optional = false)
    @Column(name = "FECHA_ACTIV_LEVEL_PARTI", nullable = false)
    private int fechaActivLevelParti;
    @Basic(optional = false)
    @Column(name = "TIPO_TARJETA_HP", nullable = false)
    private short tipoTarjetaHp;
    @Basic(optional = false)
    @Column(name = "MARCA_TARJETA_HP", nullable = false)
    private short marcaTarjetaHp;

    public S4bmcint() {
    }

    public S4bmcint(S4bmcintPK s4bmcintPK) {
        this.s4bmcintPK = s4bmcintPK;
    }

    public S4bmcint(S4bmcintPK s4bmcintPK, short longBin, String marcaMaster, String tipoTarjeMaster, long identifMiembro, String tipoProduMaster, int endpoint, String codPaisMaster, short codPaisMasterNum, String regionMas, short codMonMas, short expCodMon, String claseProducto, String indRutaTrans, String indReasignarProdu, int fechaModific, String indCashback, String indReasigFirstPre, String indPaypass, String indLevelParti, int fechaActivLevelParti, short tipoTarjetaHp, short marcaTarjetaHp) {
        this.s4bmcintPK = s4bmcintPK;
        this.longBin = longBin;
        this.marcaMaster = marcaMaster;
        this.tipoTarjeMaster = tipoTarjeMaster;
        this.identifMiembro = identifMiembro;
        this.tipoProduMaster = tipoProduMaster;
        this.endpoint = endpoint;
        this.codPaisMaster = codPaisMaster;
        this.codPaisMasterNum = codPaisMasterNum;
        this.regionMas = regionMas;
        this.codMonMas = codMonMas;
        this.expCodMon = expCodMon;
        this.claseProducto = claseProducto;
        this.indRutaTrans = indRutaTrans;
        this.indReasignarProdu = indReasignarProdu;
        this.fechaModific = fechaModific;
        this.indCashback = indCashback;
        this.indReasigFirstPre = indReasigFirstPre;
        this.indPaypass = indPaypass;
        this.indLevelParti = indLevelParti;
        this.fechaActivLevelParti = fechaActivLevelParti;
        this.tipoTarjetaHp = tipoTarjetaHp;
        this.marcaTarjetaHp = marcaTarjetaHp;
    }

    public S4bmcint(String binRangoSuperior, String binRangoInferior, short codProceso) {
        this.s4bmcintPK = new S4bmcintPK(binRangoSuperior, binRangoInferior, codProceso);
    }

    public S4bmcintPK getS4bmcintPK() {
        return s4bmcintPK;
    }

    public void setS4bmcintPK(S4bmcintPK s4bmcintPK) {
        this.s4bmcintPK = s4bmcintPK;
    }

    public short getLongBin() {
        return longBin;
    }

    public void setLongBin(short longBin) {
        this.longBin = longBin;
    }

    public String getMarcaMaster() {
        return marcaMaster;
    }

    public void setMarcaMaster(String marcaMaster) {
        this.marcaMaster = marcaMaster;
    }

    public String getTipoTarjeMaster() {
        return tipoTarjeMaster;
    }

    public void setTipoTarjeMaster(String tipoTarjeMaster) {
        this.tipoTarjeMaster = tipoTarjeMaster;
    }

    public long getIdentifMiembro() {
        return identifMiembro;
    }

    public void setIdentifMiembro(long identifMiembro) {
        this.identifMiembro = identifMiembro;
    }

    public String getTipoProduMaster() {
        return tipoProduMaster;
    }

    public void setTipoProduMaster(String tipoProduMaster) {
        this.tipoProduMaster = tipoProduMaster;
    }

    public int getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(int endpoint) {
        this.endpoint = endpoint;
    }

    public String getCodPaisMaster() {
        return codPaisMaster;
    }

    public void setCodPaisMaster(String codPaisMaster) {
        this.codPaisMaster = codPaisMaster;
    }

    public short getCodPaisMasterNum() {
        return codPaisMasterNum;
    }

    public void setCodPaisMasterNum(short codPaisMasterNum) {
        this.codPaisMasterNum = codPaisMasterNum;
    }

    public String getRegionMas() {
        return regionMas;
    }

    public void setRegionMas(String regionMas) {
        this.regionMas = regionMas;
    }

    public short getCodMonMas() {
        return codMonMas;
    }

    public void setCodMonMas(short codMonMas) {
        this.codMonMas = codMonMas;
    }

    public short getExpCodMon() {
        return expCodMon;
    }

    public void setExpCodMon(short expCodMon) {
        this.expCodMon = expCodMon;
    }

    public String getClaseProducto() {
        return claseProducto;
    }

    public void setClaseProducto(String claseProducto) {
        this.claseProducto = claseProducto;
    }

    public String getIndRutaTrans() {
        return indRutaTrans;
    }

    public void setIndRutaTrans(String indRutaTrans) {
        this.indRutaTrans = indRutaTrans;
    }

    public String getIndReasignarProdu() {
        return indReasignarProdu;
    }

    public void setIndReasignarProdu(String indReasignarProdu) {
        this.indReasignarProdu = indReasignarProdu;
    }

    public int getFechaModific() {
        return fechaModific;
    }

    public void setFechaModific(int fechaModific) {
        this.fechaModific = fechaModific;
    }

    public String getIndCashback() {
        return indCashback;
    }

    public void setIndCashback(String indCashback) {
        this.indCashback = indCashback;
    }

    public String getIndReasigFirstPre() {
        return indReasigFirstPre;
    }

    public void setIndReasigFirstPre(String indReasigFirstPre) {
        this.indReasigFirstPre = indReasigFirstPre;
    }

    public String getIndPaypass() {
        return indPaypass;
    }

    public void setIndPaypass(String indPaypass) {
        this.indPaypass = indPaypass;
    }

    public String getIndLevelParti() {
        return indLevelParti;
    }

    public void setIndLevelParti(String indLevelParti) {
        this.indLevelParti = indLevelParti;
    }

    public int getFechaActivLevelParti() {
        return fechaActivLevelParti;
    }

    public void setFechaActivLevelParti(int fechaActivLevelParti) {
        this.fechaActivLevelParti = fechaActivLevelParti;
    }

    public short getTipoTarjetaHp() {
        return tipoTarjetaHp;
    }

    public void setTipoTarjetaHp(short tipoTarjetaHp) {
        this.tipoTarjetaHp = tipoTarjetaHp;
    }

    public short getMarcaTarjetaHp() {
        return marcaTarjetaHp;
    }

    public void setMarcaTarjetaHp(short marcaTarjetaHp) {
        this.marcaTarjetaHp = marcaTarjetaHp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (s4bmcintPK != null ? s4bmcintPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof S4bmcint)) {
            return false;
        }
        S4bmcint other = (S4bmcint) object;
        if ((this.s4bmcintPK == null && other.s4bmcintPK != null) || (this.s4bmcintPK != null && !this.s4bmcintPK.equals(other.s4bmcintPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "S4bmcint[ "+ s4bmcintPK + " ]";
    }
    
}
