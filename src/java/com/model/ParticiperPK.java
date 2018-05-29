/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nico
 */
@Embeddable
public class ParticiperPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROPOSITION")
    private long idProposition;

    public ParticiperPK() {
    }

    public ParticiperPK(long id, long idProposition) {
        this.id = id;
        this.idProposition = idProposition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdProposition() {
        return idProposition;
    }

    public void setIdProposition(long idProposition) {
        this.idProposition = idProposition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) idProposition;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticiperPK)) {
            return false;
        }
        ParticiperPK other = (ParticiperPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.idProposition != other.idProposition) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.ParticiperPK[ id=" + id + ", idProposition=" + idProposition + " ]";
    }
    
}
