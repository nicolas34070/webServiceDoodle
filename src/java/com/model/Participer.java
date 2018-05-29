/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nico
 */
@Entity
@Table(name = "PARTICIPER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participer.findAll", query = "SELECT p FROM Participer p")
    , @NamedQuery(name = "Participer.findBySiparticipe", query = "SELECT p FROM Participer p WHERE p.siparticipe = :siparticipe")
    , @NamedQuery(name = "Participer.findById", query = "SELECT p FROM Participer p WHERE p.participerPK.id = :id")
    , @NamedQuery(name = "Participer.findByIdProposition", query = "SELECT p FROM Participer p WHERE p.participerPK.idProposition = :idProposition")})
public class Participer implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParticiperPK participerPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIPARTICIPE")
    private short siparticipe;
    @JoinColumn(name = "ID_PROPOSITION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proposition proposition;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Participer() {
    }

    public Participer(ParticiperPK participerPK) {
        this.participerPK = participerPK;
    }

    public Participer(ParticiperPK participerPK, short siparticipe) {
        this.participerPK = participerPK;
        this.siparticipe = siparticipe;
    }

    public Participer(long id, long idProposition) {
        this.participerPK = new ParticiperPK(id, idProposition);
    }

    public ParticiperPK getParticiperPK() {
        return participerPK;
    }

    public void setParticiperPK(ParticiperPK participerPK) {
        this.participerPK = participerPK;
    }

    public short getSiparticipe() {
        return siparticipe;
    }

    public void setSiparticipe(short siparticipe) {
        this.siparticipe = siparticipe;
    }

    public Proposition getProposition() {
        return proposition;
    }

    public void setProposition(Proposition proposition) {
        this.proposition = proposition;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participerPK != null ? participerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participer)) {
            return false;
        }
        Participer other = (Participer) object;
        if ((this.participerPK == null && other.participerPK != null) || (this.participerPK != null && !this.participerPK.equals(other.participerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Participer[ participerPK=" + participerPK + " ]";
    }
    
}
