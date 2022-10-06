/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redsys.llaa.model.h2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 *
 * @author S3316AM
 */
@Entity
@Table(name = "IP0040",
       indexes = @Index(name = "IP0040_IX", columnList="ranmen,ranmay,acbrprio")
)
@NamedQueries({
    @NamedQuery(name = "Ip0040.findAll", query = "SELECT i FROM Ip0040 i")
    , @NamedQuery(name = "Ip0040.findByRango", query = "SELECT i FROM Ip0040 i WHERE i.ranmen <= :ranmen and i.ranmay >= :ranmay and i.acbrprio=1 order by i.datefile desc")
    , @NamedQuery(name = "Ip0040.findByIp0040Id", query = "SELECT i FROM Ip0040 i WHERE i.ip0040Id = :ip0040Id")
    })
public class Ip0040 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IP0040_ID", nullable = false)
    private Long ip0040Id;
    @Column(name = "DATEFILE", length = 10)
    private String datefile;
    @Column(name = "CODACT", length = 1)
    private String codact;
    @Column(name = "TABLA", length = 8)
    private String tabla;
    @Column(name = "RANMEN", length = 19)
    private String ranmen;
    @Column(name = "IDPROD", length = 3)
    private String idprod;
    @Column(name = "RANMAY", length = 19)
    private String ranmay;
    @Column(name = "ACEPBRAND", length = 3)
    private String acepbrand;
    @Column(name = "ACBRPRIO")
    private Short acbrprio;
    @Column(name = "MBRID")
    private Long mbrid;
    @Column(name = "TIPOPROD")
    private Short tipoprod;
    @Column(name = "ENDPOINT")
    private Integer endpoint;
    @Column(name = "INDFORMAT", length = 1)
    private String indformat;
    @Column(name = "PAISALFA", length = 3)
    private String paisalfa;
    @Column(name = "PAISNUM")
    private Short paisnum;
    @Column(name = "REGION", length = 1)
    private String region;
    @Column(name = "MONEDA")
    private Short moneda;
    @Column(name = "EXPONENTE")
    private Short exponente;
    @Column(name = "OCCURS_MONEDAS", length = 28)
    private String occursMonedas;
    @Column(name = "FILLER", length = 1)
    private String filler;
    @Column(name = "ROUTING", length = 1)
    private String routing;
    @Column(name = "REASSW", length = 1)
    private String reassw;
    @Column(name = "PAYPASS", length = 1)
    private String paypass;
    @Column(name = "CLASEPROD", length = 3)
    private String claseprod;

    public Ip0040() {
    }

    public Ip0040(Long ip0040Id) {
        this.ip0040Id = ip0040Id;
    }

    public Long getIp0040Id() {
        return ip0040Id;
    }

    public void setIp0040Id(Long ip0040Id) {
        this.ip0040Id = ip0040Id;
    }

    public String getDatefile() {
        return datefile;
    }

    public void setDatefile(String datefile) {
        this.datefile = datefile;
    }

    public String getCodact() {
        return codact;
    }

    public void setCodact(String codact) {
        this.codact = codact;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getRanmen() {
        return ranmen;
    }

    public void setRanmen(String ranmen) {
        this.ranmen = ranmen;
    }

    public String getIdprod() {
        return idprod;
    }

    public void setIdprod(String idprod) {
        this.idprod = idprod;
    }

    public String getRanmay() {
        return ranmay;
    }

    public void setRanmay(String ranmay) {
        this.ranmay = ranmay;
    }

    public String getAcepbrand() {
        return acepbrand;
    }

    public void setAcepbrand(String acepbrand) {
        this.acepbrand = acepbrand;
    }

    public Short getAcbrprio() {
        return acbrprio;
    }

    public void setAcbrprio(Short acbrprio) {
        this.acbrprio = acbrprio;
    }

    public Long getMbrid() {
        return mbrid;
    }

    public void setMbrid(Long mbrid) {
        this.mbrid = mbrid;
    }

    public Short getTipoprod() {
        return tipoprod;
    }

    public void setTipoprod(Short tipoprod) {
        this.tipoprod = tipoprod;
    }

    public Integer getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(Integer endpoint) {
        this.endpoint = endpoint;
    }

    public String getIndformat() {
        return indformat;
    }

    public void setIndformat(String indformat) {
        this.indformat = indformat;
    }

    public String getPaisalfa() {
        return paisalfa;
    }

    public void setPaisalfa(String paisalfa) {
        this.paisalfa = paisalfa;
    }

    public Short getPaisnum() {
        return paisnum;
    }

    public void setPaisnum(Short paisnum) {
        this.paisnum = paisnum;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Short getMoneda() {
        return moneda;
    }

    public void setMoneda(Short moneda) {
        this.moneda = moneda;
    }

    public Short getExponente() {
        return exponente;
    }

    public void setExponente(Short exponente) {
        this.exponente = exponente;
    }

    public String getOccursMonedas() {
        return occursMonedas;
    }

    public void setOccursMonedas(String occursMonedas) {
        this.occursMonedas = occursMonedas;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    public String getRouting() {
        return routing;
    }

    public void setRouting(String routing) {
        this.routing = routing;
    }

    public String getReassw() {
        return reassw;
    }

    public void setReassw(String reassw) {
        this.reassw = reassw;
    }

    public String getPaypass() {
        return paypass;
    }

    public void setPaypass(String paypass) {
        this.paypass = paypass;
    }

    public String getClaseprod() {
        return claseprod;
    }

    public void setClaseprod(String claseprod) {
        this.claseprod = claseprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ip0040Id != null ? ip0040Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ip0040)) {
            return false;
        }
        Ip0040 other = (Ip0040) object;
        if ((this.ip0040Id == null && other.ip0040Id != null) || (this.ip0040Id != null && !this.ip0040Id.equals(other.ip0040Id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "Ip0040[ ip0040Id=" + ip0040Id + " ]";
//    }

    @Override
    public String toString() {
        return "Ip0040{" + "ranmen=" + ranmen + ", idprod=" + idprod + ", ranmay=" + ranmay 
                + ", acepbrand=" + acepbrand + ", acbrprio=" + acbrprio + ", mbrid=" + mbrid 
                + ", tipoprod=" + tipoprod + ", endpoint=" + endpoint + ", indformat=" + indformat 
                + ", paisalfa=" + paisalfa + ", paisnum=" + paisnum + ", region=" + region 
                + ", moneda=" + moneda + '}';
    }

    
}
