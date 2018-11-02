package vn.hcmute.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hcmute.onlineshop.entity.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findAccountByUsernameAndPassword(String username, String password);
    Optional<Account> findAccountByUsername(String username);
}
