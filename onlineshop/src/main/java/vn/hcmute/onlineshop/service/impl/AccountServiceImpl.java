package vn.hcmute.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmute.onlineshop.entity.Account;
import vn.hcmute.onlineshop.exception.NotFoundException;
import vn.hcmute.onlineshop.repository.AccountRepository;
import vn.hcmute.onlineshop.service.AccountService;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @PersistenceContext
    EntityManager em;
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

    @Override
    public List<Account> getAllAccounts(String keyword) {
        StoredProcedureQuery query = em.createStoredProcedureQuery("Sp_GetAccounts", Account.class);
        query.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
        query.setParameter(0, keyword);
        query.execute();
        List<Account> accounts = query.getResultList();
        return accounts;
    }
}
