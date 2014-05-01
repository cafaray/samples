package com.palestra.wf.model.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

public class GeneraIdentificador {

	public GeneraIdentificador() {}
	
	public static String toMD5(String valor) {
        String retorno = "";
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            String chorizo = valor;
            digest.update(chorizo.getBytes("ISO-8859-1"));
            byte[] sausage = digest.digest();
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < sausage.length; i++) {
                hexString.append(Integer.toHexString(0xFF & sausage[i]));
            }
            retorno = hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(GeneraIdentificador.class.getName());
            ex.printStackTrace(System.out);
        } catch (UnsupportedEncodingException ex) {
            System.out.println(GeneraIdentificador.class.getName());
            ex.printStackTrace(System.out);
        }
        return retorno;
    }
	
	public static String toMD5() {
        String retorno = "";
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            Double random = Math.random()*Calendar.getInstance().getTimeInMillis();
            String chorizo = String.valueOf(random);
            digest.update(chorizo.getBytes("ISO-8859-1"));
            byte[] sausage = digest.digest();
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < sausage.length; i++) {
                hexString.append(Integer.toHexString(0xFF & sausage[i]));
            }
            retorno = hexString.toString();
            if(retorno.length()>32){
            	retorno = retorno.substring(0,33);
            }else if(retorno.length() <32){
            	retorno = rellenaCeros(retorno, 32);
            }
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(GeneraIdentificador.class.getName());
            ex.printStackTrace(System.out);
        } catch (UnsupportedEncodingException ex) {
            System.out.println(GeneraIdentificador.class.getName());
            ex.printStackTrace(System.out);
        }
        return retorno;
    }
	
	private static String rellenaCeros(String cadena, int lngTotal) {
        if (cadena.length() >= lngTotal) {
            return cadena;
        }
        String retorno = "";
        for (int x = cadena.length(); x < lngTotal; x++) {
            retorno += "0";
        }
        retorno += cadena;
        return retorno;
    }
}
