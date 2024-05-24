package com.enspd.release.Exceptions;

public class NullArgumentException extends RuntimeException {

    public String msg;

    public NullArgumentException(){}

    public NullArgumentException(String msg){
        super(msg);
        this.msg=msg;

    }
}
