package com.enspd.release.Exceptions;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorResponse {

    private int Status_Code;

    private String error;

    private Date date;

    
    
}
