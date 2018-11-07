package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "historys")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date loginDate;
    private Date logoutDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    public History() {
    }

    public History(Date loginDate, Date logoutDate, Account account) {
        this.loginDate = loginDate;
        this.logoutDate = logoutDate;
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
