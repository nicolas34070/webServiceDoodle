package com.model;

import com.model.Participer;
import com.model.Sondage;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-29T18:18:50")
@StaticMetamodel(Proposition.class)
public class Proposition_ { 

    public static volatile SingularAttribute<Proposition, Sondage> idSondage;
    public static volatile CollectionAttribute<Proposition, Participer> participerCollection;
    public static volatile SingularAttribute<Proposition, Date> datedebut;
    public static volatile SingularAttribute<Proposition, Long> totalvote;
    public static volatile SingularAttribute<Proposition, Date> datefin;
    public static volatile SingularAttribute<Proposition, Long> id;

}