/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redsys.llaa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author S3316AM
 */
@Embeddable
public class S4bmcintPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "BIN_RANGO_SUPERIOR", nullable = false, length = 19)
    private String binRangoSuperior;
    @Basic(optional = false)
    @Column(name = "BIN_RANGO_INFERIOR", nullable = false, length = 19)
    private String binRangoInferior;
    @Basic(optional = false)
    @Column(name = "COD_PROCESO", nullable = false)
    private short codProceso;

    public S4bmcintPK() {
    }

    public S4bmcintPK(String binRangoSuperior, String binRangoInferior, short codProceso) {
        this.binRangoSuperior = binRangoSuperior;
        this.binRangoInferior = binRangoInferior;
        this.codProceso = codProceso;
    }

    public String getBinRangoSuperior() {
        return binRangoSuperior;
    }

    public void setBinRangoSuperior(String binRangoSuperior) {
        this.binRangoSuperior = binRangoSuperior;
    }

    public String getBinRangoInferior() {
        return binRangoInferior;
    }

    public void setBinRangoInferior(String binRangoInferior) {
        this.binRangoInferior = binRangoInferior;
    }

    public short getCodProceso() {
        return codProceso;
    }

    public void setCodProceso(short codProceso) {
        this.codProceso = codProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (binRangoSuperior != null ? binRangoSuperior.hashCode() : 0);
        hash += (binRangoInferior != null ? binRangoInferior.hashCode() : 0);
        hash += (int) codProceso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof S4bmcintPK)) {
            return false;
        }
        S4bmcintPK other = (S4bmcintPK) object;
        if ((this.binRangoSuperior == null && other.binRangoSuperior != null) || (this.binRangoSuperior != null && !this.binRangoSuperior.equals(other.binRangoSuperior))) {
            return false;
        }
        if ((this.binRangoInferior == null && other.binRangoInferior != null) || (this.binRangoInferior != null && !this.binRangoInferior.equals(other.binRangoInferior))) {
            return false;
        }
        if (this.codProceso != other.codProceso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "S4bmcintPK[ binRangoSuperior=" + binRangoSuperior + ", binRangoInferior=" + binRangoInferior + ", codProceso=" + codProceso + " ]";
    }
    
}
