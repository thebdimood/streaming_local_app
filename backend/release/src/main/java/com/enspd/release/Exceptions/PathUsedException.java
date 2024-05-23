package com.enspd.release.Exceptions;

public class PathUsedException extends RuntimeException {
    
    public String msg;

    public PathUsedException(){}

    public PathUsedException(String msg){
        super(msg);
        this.msg=msg;
    }
}
