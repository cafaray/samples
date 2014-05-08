package com.ftc.aspel.model;

import com.ftc.aspel.model.Movimiento;
import com.ftc.aspel.model.Sesion;
import com.ftc.aspel.model.UsuarioDetalle;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-06T13:22:53")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> dsvalcon;
    public static volatile SingularAttribute<Usuario, String> instatus;
    public static volatile SingularAttribute<Usuario, Integer> idusucon;
    public static volatile SingularAttribute<Usuario, String> dsusucon;
    public static volatile ListAttribute<Usuario, Sesion> sesionList;
    public static volatile SingularAttribute<Usuario, UsuarioDetalle> usuarioDetalle;
    public static volatile SingularAttribute<Usuario, Date> tmstmp;
    public static volatile ListAttribute<Usuario, Movimiento> movimientoList;

}