package com.ftc.aspel.model;

import com.ftc.aspel.model.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-06T13:22:53")
@StaticMetamodel(Sesion.class)
public class Sesion_ { 

    public static volatile SingularAttribute<Sesion, String> instatus;
    public static volatile SingularAttribute<Sesion, String> dstoken;
    public static volatile SingularAttribute<Sesion, Integer> idnumses;
    public static volatile SingularAttribute<Sesion, Usuario> idusuari;
    public static volatile SingularAttribute<Sesion, Date> dtfecini;
    public static volatile SingularAttribute<Sesion, Date> dtfecfin;
    public static volatile SingularAttribute<Sesion, Date> tmstmp;

}