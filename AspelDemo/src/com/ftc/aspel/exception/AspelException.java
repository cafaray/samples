package com.ftc.aspel.exception;

public class AspelException extends Exception{
    public AspelException(){super();}
    public AspelException(String message){super(message);}
    public AspelException(String message, Throwable cause){super(message, cause);}
    public AspelException(Throwable cause){super(cause);}
}
