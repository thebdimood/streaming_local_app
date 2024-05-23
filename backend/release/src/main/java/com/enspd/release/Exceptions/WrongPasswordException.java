package com.enspd.release.Exceptions;

public class WrongPasswordException extends RuntimeException {
    
    public String msg;

    public WrongPasswordException(){}

    public WrongPasswordException(String msg){
        super(msg);
        this.msg=msg;
    }
}
