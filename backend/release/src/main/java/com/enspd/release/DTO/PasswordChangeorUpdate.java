package com.enspd.release.DTO;

import lombok.Data;

@Data
public class PasswordChangeorUpdate {
    private Integer id;
    
    private String oldpassword;

    private String newpassword;
}
