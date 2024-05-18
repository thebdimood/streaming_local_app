package com.enspd.release.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enspd.release.DTO.AccountCreationRequestDTO;
import com.enspd.release.DTO.AccountDeleteDTO;
import com.enspd.release.DTO.AccountRequestDTO;
import com.enspd.release.DTO.AccountUpdateRequestDTO;
import com.enspd.release.DTO.PasswordChangeorUpdate;
import com.enspd.release.Repositories.AccountRepository;
import com.enspd.release.models.AccountEntity;

@Service
public class AccountServiceImpl implements  AccountService {

/* implementation du service de gestion des utilisateurs de la plateforme  */
    @Autowired
    private AccountRepository accountRepository;


    /*
     * recuperation d'un compte en particulier a partir de son identifiant
     * @required param :id
     * 
     * @exceptions: le compte rechercher n'existe pas en base de donnee
     */
    @Override
    public AccountRequestDTO AccountInfo(Integer id) {
        AccountEntity accountEntity= accountRepository.findById(id).orElseThrow();
        AccountRequestDTO accountRequestDTO= new AccountRequestDTO();
        accountRequestDTO.setCreatedOn(accountEntity.getCreatedOn());
        accountRequestDTO.setId(accountEntity.getId());
        accountRequestDTO.setName(accountEntity.getName());
        accountRequestDTO.setUsername(accountEntity.getUsername());

        return accountRequestDTO;
    }


    /*
     * cette operation permet la mise a jour des informations du compte hormis le mots de passe
     * @param  required id 
     * @param  name
     * @param username
     * 
     * 
     * @exception : le compte recherche n'existe pas en base de donnees
     */
    @Override
    public AccountRequestDTO UpdateInfo(AccountUpdateRequestDTO accountUpdateRequestDTO) {
        
        AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
            AccountEntity accountEntity= accountRepository.findById(accountUpdateRequestDTO.getId()).orElseThrow();
            if(accountEntity.getPassword()==accountUpdateRequestDTO.getPassword()){
                
                //TODO ajouter les exceptions 
                if(accountUpdateRequestDTO.getName()!=null){
                    accountEntity.setName(accountUpdateRequestDTO.getName());
                }
                if(accountUpdateRequestDTO.getUsername()!=null){
                    accountEntity.setUsername(accountUpdateRequestDTO.getUsername());
                }

                AccountEntity accountUpdated = accountRepository.save(accountEntity);

                accountRequestDTO.setName(accountUpdated.getName());
                accountRequestDTO.setUsername(accountUpdated.getUsername());
                accountRequestDTO.setCreatedOn(accountUpdated.getCreatedOn());
                accountRequestDTO.setId(accountUpdated.getId());
                
            } 
            return accountRequestDTO;


    }

    /*
     * cette operation permet de mettre a jour le mot de passe d'un compte en particulier
     * @required param :id
     * @required param : old password
     * @required param: new password
     * 
     * exceptions: 
     * 1. le compte recherche n'existe pas
     * 2. le old password est incorrect
     */
    @Override
    public void ChangePassword(PasswordChangeorUpdate passwordChangeorUpdate) {
        // TODO Auto-generated method stub
        
        AccountEntity accountEntity= accountRepository.findById(passwordChangeorUpdate.getId()).orElseThrow();

        if(accountEntity.getPassword()==passwordChangeorUpdate.getOldpassword()){
           /*
            * new password authenticity correction
            */
            String new_password= passwordChangeorUpdate.getNewpassword();
            if(new_password.length()>=8){
                accountEntity.setPassword(new_password);
                accountRepository.save(accountEntity);
                
            }
        }
    }

/*
 * cette operation permet davoir la liste des comptes sur la plateforme sans aucun filtrage a faire avec beaucoup de precaution
 * operation longue en base de donnee
 * no required param 
 */
    @Override
    public List<AccountRequestDTO> ListofAccount() {
      List<AccountEntity> listAccountEntities= accountRepository.findAll();

      List<AccountRequestDTO> accountRequestDTOs= new ArrayList<>();

      for(AccountEntity accountEntity: listAccountEntities){

        AccountRequestDTO accountRequestDTO= new AccountRequestDTO();
        accountRequestDTO.setCreatedOn(accountEntity.getCreatedOn());
        accountRequestDTO.setName(accountEntity.getName());
        accountRequestDTO.setUsername(accountEntity.getUsername());
        accountRequestDTO.setId(accountEntity.getId());
        accountRequestDTOs.add(accountRequestDTO);
      }

      return accountRequestDTOs;
    }

    /*
     * cette operation permet de supprimer un compte de la base de donnees
     * @required param: id
     * @required param : password
     * 
     * @Exceptions: 
     * 1. le compte rechercher n'existe pas en base de donnee
     * 2. le mot de passe fourni n'est pas correct
     */

    @Override
    public void DeleteAccount(AccountDeleteDTO accountDeleteDTO) {
       AccountEntity accountEntity= accountRepository.findById(accountDeleteDTO.getId()).orElseThrow();
       if(accountEntity.getPassword()==accountDeleteDTO.getPassword()){
        accountRepository.delete(accountEntity);
       }
    }

    @Override
    public AccountRequestDTO CreateAccount(AccountCreationRequestDTO accountCreationRequestDTO) {
       AccountEntity accountEntity= new AccountEntity();
       Date date=new Date(System.currentTimeMillis());
       
       accountEntity.setUsername(accountCreationRequestDTO.getUsername());
       accountEntity.setSurname(accountCreationRequestDTO.getSurname());
       accountEntity.setName(accountCreationRequestDTO.getName());
       accountEntity.setPassword(accountCreationRequestDTO.getPassword());
       accountEntity.setCreatedOn(date);

       AccountEntity accountSaved= accountRepository.save(accountEntity);

       AccountRequestDTO accountRequestDTO= new AccountRequestDTO();

       accountRequestDTO.setCreatedOn(accountSaved.getCreatedOn());
       accountRequestDTO.setId(accountSaved.getId());
       accountRequestDTO.setName(accountSaved.getName());
       accountRequestDTO.setUsername(accountSaved.getUsername());

       return accountRequestDTO;
       
    }
    
}
