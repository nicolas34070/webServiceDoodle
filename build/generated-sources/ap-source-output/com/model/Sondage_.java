package com.model;

import com.model.Proposition;
import com.model.Utilisateur;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-29T18:18:50")
@StaticMetamodel(Sondage.class)
public class Sondage_ { 

    public static volatile CollectionAttribute<Sondage, Utilisateur> utilisateurCollection;
    public static volatile SingularAttribute<Sondage, String> titre;
    public static volatile CollectionAttribute<Sondage, Proposition> propositionCollection;
    public static volatile SingularAttribute<Sondage, Date> datecreation;
    public static volatile SingularAttribute<Sondage, BigDecimal> id;
    public static volatile SingularAttribute<Sondage, String> commentaire;
    public static volatile SingularAttribute<Sondage, String> lieu;

}