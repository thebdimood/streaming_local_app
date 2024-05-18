package com.enspd.release.DTO;

import lombok.Data;

@Data
public class AccountCreationRequestDTO {

    private String username;

    private String name;

    private String password;
    
    private String surname;
}
