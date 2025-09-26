package com.example.banking_app.service.implement;

import com.example.banking_app.dto.AccountDto;
import com.example.banking_app.entity.Account;
import com.example.banking_app.mapper.AccountMapper;
import com.example.banking_app.repository.AccountRepo;
import com.example.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImplement implements AccountService {

    private final AccountRepo accRepo;

    public AccountServiceImplement(AccountRepo accRepo) {
        this.accRepo = accRepo;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account ac = AccountMapper.mapToAccount(accountDto);
        Account saved = accRepo.save(ac);
        return AccountMapper.mapToAccount(saved);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account ac = accRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccount(ac);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account ac = accRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
        ac.setBalance(ac.getBalance() + amount);
        Account savedAccount = accRepo.save(ac);
        return AccountMapper.mapToAccount(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account ac = accRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
        if(ac.getBalance() < amount){
            throw new RuntimeException("Insufficient amount");
        }
        ac.setBalance(ac.getBalance() - amount);
        Account saved = accRepo.save(ac);
        return AccountMapper.mapToAccount(saved);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accRepo.findAll();
        return accounts.stream()
                .map(AccountMapper::mapToAccount)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account ac = accRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
        accRepo.deleteById(id);
    }
}
