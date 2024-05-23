package com.enspd.release.Exceptions;

public class RessourceNotFoundException extends RuntimeException{
    
    public String msg;

    public RessourceNotFoundException(){};


    public RessourceNotFoundException(String msg){
        super(msg);
        this.msg=msg;
    }
}
