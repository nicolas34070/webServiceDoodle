/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nico
 */
@Entity
@Table(name = "PROPOSITION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proposition.findAll", query = "SELECT p FROM Proposition p")
    , @NamedQuery(name = "Proposition.findById", query = "SELECT p FROM Proposition p WHERE p.id = :id")
    , @NamedQuery(name = "Proposition.findByDatedebut", query = "SELECT p FROM Proposition p WHERE p.datedebut = :datedebut")
    , @NamedQuery(name = "Proposition.findByDatefin", query = "SELECT p FROM Proposition p WHERE p.datefin = :datefin")
    , @NamedQuery(name = "Proposition.findByTotalvote", query = "SELECT p FROM Proposition p WHERE p.totalvote = :totalvote")})
public class Proposition implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEDEBUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebut;
    @Column(name = "DATEFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALVOTE")
    private long totalvote;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proposition")
    private Collection<Participer> participerCollection;
    @JoinColumn(name = "ID_SONDAGE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sondage idSondage;

    public Proposition() {
    }

    public Proposition(Long id) {
        this.id = id;
    }

    public Proposition(Long id, Date datedebut, long totalvote) {
        this.id = id;
        this.datedebut = datedebut;
        this.totalvote = totalvote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public long getTotalvote() {
        return totalvote;
    }

    public void setTotalvote(long totalvote) {
        this.totalvote = totalvote;
    }

    @XmlTransient
    public Collection<Participer> getParticiperCollection() {
        return participerCollection;
    }

    public void setParticiperCollection(Collection<Participer> participerCollection) {
        this.participerCollection = participerCollection;
    }

    public Sondage getIdSondage() {
        return idSondage;
    }

    public void setIdSondage(Sondage idSondage) {
        this.idSondage = idSondage;
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
        if (!(object instanceof Proposition)) {
            return false;
        }
        Proposition other = (Proposition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Proposition[ id=" + id + " ]";
    }
    
}
