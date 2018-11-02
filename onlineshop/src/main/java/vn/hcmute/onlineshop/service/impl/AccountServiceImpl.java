package vn.hcmute.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmute.onlineshop.entity.Account;
import vn.hcmute.onlineshop.exception.NotFoundException;
import vn.hcmute.onlineshop.repository.AccountRepository;
import vn.hcmute.onlineshop.service.AccountService;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account findAccountByUsernameAndPassword(String username, String password) {
        Optional<Account> accountOptional=accountRepository.findAccountByUsernameAndPassword(username,password);
        if(!accountOptional.isPresent()){
            throw new NotFoundException("Not found username/password");
        }
        return accountOptional.get();
    }

    @Override
    public boolean findAccountByUsername(String username) {
        Optional<Account> accountOptional=accountRepository.findAccountByUsername(username);
        if(accountOptional.isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
