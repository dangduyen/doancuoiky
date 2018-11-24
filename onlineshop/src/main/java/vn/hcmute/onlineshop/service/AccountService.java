package vn.hcmute.onlineshop.service;

import vn.hcmute.onlineshop.entity.Account;
import vn.hcmute.onlineshop.model.dto.AccountDto;
import vn.hcmute.onlineshop.model.response.DataReturn;

import java.util.List;

public interface AccountService {
    AccountDto findAccountByUsernameAndPassword(String username, String password);
    boolean findAccountByUsername(String username);
    Account save(Account account);
    List<Account> getAllAccounts(String keyword);
    DataReturn deleteAccount(long id);
}
