package com.ftc.aspel.model;

import com.ftc.aspel.model.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-06T13:22:53")
@StaticMetamodel(Movimiento.class)
public class Movimiento_ { 

    public static volatile SingularAttribute<Movimiento, String> instatus;
    public static volatile SingularAttribute<Movimiento, Integer> idnummov;
    public static volatile SingularAttribute<Movimiento, String> idnumcoi;
    public static volatile SingularAttribute<Movimiento, String> cddocume;
    public static volatile SingularAttribute<Movimiento, Usuario> idusuari;
    public static volatile SingularAttribute<Movimiento, Date> tmstmp;
    public static volatile SingularAttribute<Movimiento, Double> dbimport;
    public static volatile SingularAttribute<Movimiento, Integer> cddocpar;

}