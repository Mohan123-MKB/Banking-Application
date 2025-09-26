package com.example.banking_app.mapper;

import com.example.banking_app.dto.AccountDto;
import com.example.banking_app.entity.Account;

//use this class in service implementation
public class AccountMapper {
    //convert dto into entity
    //post method ku(dto -> entity)
    public static Account mapToAccount(AccountDto accDto){
        Account ac=new Account(
                accDto.getId(),
                accDto.getAccountHolderName(),
                accDto.getBalance()
        );
        return ac;
    }
    //get method ku(entity -> dto)
    public static AccountDto mapToAccount(Account ac){
        AccountDto accDto=new AccountDto(
                ac.getId(),
                ac.getAccountHolderName(),
                ac.getBalance()
        );
        return accDto;
    }

}
