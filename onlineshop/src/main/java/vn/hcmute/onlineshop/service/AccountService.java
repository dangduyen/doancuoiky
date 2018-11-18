package vn.hcmute.onlineshop.service;

import vn.hcmute.onlineshop.entity.Account;

import java.util.List;

public interface AccountService {
    Account findAccountByUsernameAndPassword(String username,String password);
    boolean findAccountByUsername(String username);
    Account save(Account account);
    List<Account> getAllAccounts(String keyword);
}
