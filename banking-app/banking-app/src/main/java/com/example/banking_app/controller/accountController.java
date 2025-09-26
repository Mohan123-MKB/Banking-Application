package com.example.banking_app.controller;

import com.example.banking_app.dto.AccountDto;
import com.example.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts") //map all api http methods
public class accountController {

    private AccountService service;
    public accountController(AccountService service){
        this.service=service;
    }
    //add account rest api
    @PostMapping
    //@RequestBody contains json then automatically convert json to java objects
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(service.createAccount(accountDto), HttpStatus.CREATED);
    }

    //get account rest api
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto=service.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //deposit rest api
    //request body json to java objects
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        AccountDto accountDto=service.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    //withdraw rest api
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        AccountDto accountDto=service.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);

    }

    //get all account rest apis
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts=service.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //delete account rest apis
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        service.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted successfully");
    }
    //dto is data transfer object between client and service
}
