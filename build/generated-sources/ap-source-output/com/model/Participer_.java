package com.model;

import com.model.ParticiperPK;
import com.model.Proposition;
import com.model.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-29T18:18:50")
@StaticMetamodel(Participer.class)
public class Participer_ { 

    public static volatile SingularAttribute<Participer, Utilisateur> utilisateur;
    public static volatile SingularAttribute<Participer, Short> siparticipe;
    public static volatile SingularAttribute<Participer, Proposition> proposition;
    public static volatile SingularAttribute<Participer, ParticiperPK> participerPK;

}