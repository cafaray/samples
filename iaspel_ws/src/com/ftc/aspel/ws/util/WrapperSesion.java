package com.ftc.aspel.ws.util;

import com.ftc.aspel.model.Sesion;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WrapperSesion {

    private int idnumses;
    private String dstoken;
    private String dtfecini;
    private String dtfecfin;
    private String instatus;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public WrapperSesion(){}
    public WrapperSesion(Sesion sesion){
        this.idnumses = sesion.getIdnumses();
        this.dstoken = sesion.getDstoken();
        this.instatus = sesion.getInstatus();
        this.setDtfecini(sesion.getDtfecini());
        this.setDtfecfin(sesion.getDtfecfin());
    }
    
    public int getIdnumses() {
        return idnumses;
    }

    public void setIdnumses(int idnumses) {
        this.idnumses = idnumses;
    }

    public String getDstoken() {
        return dstoken;
    }

    public void setDstoken(String dstoken) {
        this.dstoken = dstoken;
    }

    public String getDtfecini() {
        return dtfecini;
    }

    public void setDtfecini(Date dtfecini) {
        this.dtfecini = dateFormat.format(dtfecini);
    }

    public void setDtfecini(String dtfecini) {
        this.dtfecini = dtfecini;
    }
    
    public String getDtfecfin() {
        return dtfecfin;
    }

    public void setDtfecfin(Date dtfecfin) {
        this.dtfecfin = dateFormat.format(dtfecfin);
    }

    public void setDtfecfin(String dtfecfin) {
        this.dtfecfin = dtfecfin;
    }

    public String getInstatus() {
        return instatus;
    }

    public void setInstatus(String instatus) {
        this.instatus = instatus;
    }

}
