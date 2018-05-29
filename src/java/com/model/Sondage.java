/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nico
 */
@Entity
@Table(name = "SONDAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sondage.findAll", query = "SELECT s FROM Sondage s")
    , @NamedQuery(name = "Sondage.findById", query = "SELECT s FROM Sondage s WHERE s.id = :id")
    , @NamedQuery(name = "Sondage.findByTitre", query = "SELECT s FROM Sondage s WHERE s.titre = :titre")
    , @NamedQuery(name = "Sondage.findByCommentaire", query = "SELECT s FROM Sondage s WHERE s.commentaire = :commentaire")
    , @NamedQuery(name = "Sondage.findByLieu", query = "SELECT s FROM Sondage s WHERE s.lieu = :lieu")
    , @NamedQuery(name = "Sondage.findByDatecreation", query = "SELECT s FROM Sondage s WHERE s.datecreation = :datecreation")})
public class Sondage implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TITRE")
    private String titre;
    @Size(max = 999)
    @Column(name = "COMMENTAIRE")
    private String commentaire;
    @Size(max = 50)
    @Column(name = "LIEU")
    private String lieu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATECREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreation;
    @ManyToMany(mappedBy = "sondageCollection")
    private Collection<Utilisateur> utilisateurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSondage")
    private Collection<Proposition> propositionCollection;

    public Sondage() {
    }

    public Sondage(BigDecimal id) {
        this.id = id;
    }

    public Sondage(BigDecimal id, String titre, Date datecreation) {
        this.id = id;
        this.titre = titre;
        this.datecreation = datecreation;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    @XmlTransient
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    @XmlTransient
    public Collection<Proposition> getPropositionCollection() {
        return propositionCollection;
    }

    public void setPropositionCollection(Collection<Proposition> propositionCollection) {
        this.propositionCollection = propositionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sondage)) {
            return false;
        }
        Sondage other = (Sondage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Sondage[ id=" + id + " ]";
    }
    
}
