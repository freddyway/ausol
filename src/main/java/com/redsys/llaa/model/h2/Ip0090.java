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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author S3316AM
 */
@Entity
@Table(name = "IP0090")
@NamedQueries({
    @NamedQuery(name = "Ip0090.findAll", query = "SELECT i FROM Ip0090 i")
    , @NamedQuery(name = "Ip0090.findByRango", query = "SELECT i FROM Ip0090 i WHERE i.ranmen <= :ranmen and i.ranmay >= :ranmay order by i.datefile desc")
    , @NamedQuery(name = "Ip0090.findByIp0090Id", query = "SELECT i FROM Ip0090 i WHERE i.ip0090Id = :ip0090Id")
    , @NamedQuery(name = "Ip0090.findByDatefile", query = "SELECT i FROM Ip0090 i WHERE i.datefile = :datefile")
    , @NamedQuery(name = "Ip0090.findByCodact", query = "SELECT i FROM Ip0090 i WHERE i.codact = :codact")
    , @NamedQuery(name = "Ip0090.findByTabla", query = "SELECT i FROM Ip0090 i WHERE i.tabla = :tabla")
    , @NamedQuery(name = "Ip0090.findByRanmen", query = "SELECT i FROM Ip0090 i WHERE i.ranmen = :ranmen")
    , @NamedQuery(name = "Ip0090.findByBuseartyprico", query = "SELECT i FROM Ip0090 i WHERE i.buseartyprico = :buseartyprico")
    , @NamedQuery(name = "Ip0090.findByBusearty", query = "SELECT i FROM Ip0090 i WHERE i.busearty = :busearty")
    , @NamedQuery(name = "Ip0090.findByBuseidcode", query = "SELECT i FROM Ip0090 i WHERE i.buseidcode = :buseidcode")
    , @NamedQuery(name = "Ip0090.findByAcbrprio", query = "SELECT i FROM Ip0090 i WHERE i.acbrprio = :acbrprio")
    , @NamedQuery(name = "Ip0090.findByAcepbrand", query = "SELECT i FROM Ip0090 i WHERE i.acepbrand = :acepbrand")
    , @NamedQuery(name = "Ip0090.findByRanmay", query = "SELECT i FROM Ip0090 i WHERE i.ranmay = :ranmay")
    , @NamedQuery(name = "Ip0090.findByLifecycle", query = "SELECT i FROM Ip0090 i WHERE i.lifecycle = :lifecycle")})
public class Ip0090 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IP0090_ID", nullable = false)
    private Long ip0090Id;
    @Column(name = "DATEFILE", length = 10)
    private String datefile;
    @Column(name = "CODACT", length = 1)
    private String codact;
    @Column(name = "TABLA", length = 8)
    private String tabla;
    @Column(name = "RANMEN", length = 19)
    private String ranmen;
    @Column(name = "BUSEARTYPRICO")
    private Short buseartyprico;
    @Column(name = "BUSEARTY", length = 1)
    private String busearty;
    @Column(name = "BUSEIDCODE", length = 6)
    private String buseidcode;
    @Column(name = "ACBRPRIO")
    private Short acbrprio;
    @Column(name = "ACEPBRAND", length = 3)
    private String acepbrand;
    @Column(name = "RANMAY", length = 19)
    private String ranmay;
    @Column(name = "LIFECYCLE", length = 1)
    private String lifecycle;

    public Ip0090() {
    }

    public Ip0090(Long ip0090Id) {
        this.ip0090Id = ip0090Id;
    }

    public Long getIp0090Id() {
        return ip0090Id;
    }

    public void setIp0090Id(Long ip0090Id) {
        this.ip0090Id = ip0090Id;
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

    public Short getBuseartyprico() {
        return buseartyprico;
    }

    public void setBuseartyprico(Short buseartyprico) {
        this.buseartyprico = buseartyprico;
    }

    public String getBusearty() {
        return busearty;
    }

    public void setBusearty(String busearty) {
        this.busearty = busearty;
    }

    public String getBuseidcode() {
        return buseidcode;
    }

    public void setBuseidcode(String buseidcode) {
        this.buseidcode = buseidcode;
    }

    public Short getAcbrprio() {
        return acbrprio;
    }

    public void setAcbrprio(Short acbrprio) {
        this.acbrprio = acbrprio;
    }

    public String getAcepbrand() {
        return acepbrand;
    }

    public void setAcepbrand(String acepbrand) {
        this.acepbrand = acepbrand;
    }

    public String getRanmay() {
        return ranmay;
    }

    public void setRanmay(String ranmay) {
        this.ranmay = ranmay;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ip0090Id != null ? ip0090Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ip0090)) {
            return false;
        }
        Ip0090 other = (Ip0090) object;
        if ((this.ip0090Id == null && other.ip0090Id != null) || (this.ip0090Id != null && !this.ip0090Id.equals(other.ip0090Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.redsys.llaa.model.Ip0090[ ip0090Id=" + ip0090Id + " ]";
    }
    
}
