package com.enspd.release.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDTO {

    private Integer id;

    private String name;
    
    private String username;

    private Date createdOn;
    
}
