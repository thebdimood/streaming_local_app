package com.enspd.release.services;

import java.util.List;

import javax.naming.NameNotFoundException;

import com.enspd.release.DTO.AccountCreationRequestDTO;
import com.enspd.release.DTO.AccountDeleteDTO;
import com.enspd.release.DTO.AccountRequestDTO;
import com.enspd.release.DTO.AccountUpdateRequestDTO;
import com.enspd.release.DTO.PasswordChangeorUpdate;

public interface AccountService {
    
    public AccountRequestDTO AccountInfo(  Integer id);

    public AccountRequestDTO UpdateInfo(AccountUpdateRequestDTO accountUpdateRequestDTO) throws NameNotFoundException;

    public void ChangePassword(PasswordChangeorUpdate passwordChangeorUpdate);

    public List<AccountRequestDTO> ListofAccount();

    public void DeleteAccount(AccountDeleteDTO accountDeleteDTO);

    public AccountRequestDTO CreateAccount(AccountCreationRequestDTO accountCreationRequestDTO);
}
