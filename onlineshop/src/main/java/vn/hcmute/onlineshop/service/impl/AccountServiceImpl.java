package vn.hcmute.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmute.onlineshop.entity.Account;
import vn.hcmute.onlineshop.exception.NotFoundException;
import vn.hcmute.onlineshop.model.dto.AccountDto;
import vn.hcmute.onlineshop.model.dto.EventDto;
import vn.hcmute.onlineshop.model.dto.RoleDto;
import vn.hcmute.onlineshop.model.response.DataReturn;
import vn.hcmute.onlineshop.repository.AccountRepository;
import vn.hcmute.onlineshop.service.AccountService;

import javax.activation.DataSource;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @PersistenceContext
    EntityManager em;
    @Override
    public AccountDto findAccountByUsernameAndPassword(String username, String password) {
        Optional<Account> accountOptional=accountRepository.findAccountByUsernameAndPassword(username,password);
        if(!accountOptional.isPresent()){
            throw new NotFoundException("Not found username/password");
        }
        AccountDto accountDtos=accountOptional
                .map(account -> new AccountDto(account.getId(),account.getUsername(),account.getPassword(),
                        account.getCustomer().getName(),
                        account.getCustomer().getEmail(),
                        account.getCustomer().getPhone(),
                        account.getLstRole().stream()
                            .map(role -> new RoleDto(role.getId(),role.getName()))
                                .collect(Collectors.toList()))).get();
        return accountDtos;
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

    @Override
    public DataReturn deleteAccount(long id) {
        StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_DeleteAccount",Account.class);
        query.registerStoredProcedureParameter(0,Long.class,ParameterMode.IN);
        query.setParameter(0,id);
        DataReturn dataReturn=new DataReturn();
        try{
            query.execute();
            dataReturn.setSuccess("true");
            List<Account> accounts=getAllAccounts("");
            List<AccountDto> accountDtos=accounts.stream()
                    .map(account -> new AccountDto(account.getId(),account.getUsername(),account.getPassword(),
                            account.getCustomer().getName(),account.getCustomer().getEmail()
                            ,account.getCustomer().getPhone(),
                            account.getLstRole().stream().map(role -> new RoleDto(role.getId(),role.getName())).collect(Collectors.toList())))
                    .collect(Collectors.toList());
            dataReturn.setData(accountDtos);
        }
        catch (Exception ex){
            dataReturn.setError(ex.getMessage());
            dataReturn.setSuccess("false");
        }
        return dataReturn;
    }
}
