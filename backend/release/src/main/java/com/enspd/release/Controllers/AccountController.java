package com.enspd.release.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enspd.release.DTO.AccountRequestDTO;
import com.enspd.release.services.AccountService;

@RestController()
@RequestMapping("api/v1/users")
public class AccountController {


    @Autowired
   private  AccountService accountService;



   /*
    * endpoints de type get pour l'administration des utilisateurs
    */

    @GetMapping("/user/{id}")
    public AccountRequestDTO getUser(@PathVariable("id") Integer id){
        return accountService.AccountInfo(id);
    }

    @GetMapping()
    public List<AccountRequestDTO>  getUsers(){
        return accountService.ListofAccount();
    }




    
}
