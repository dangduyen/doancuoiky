package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany(mappedBy = "lstRole",fetch = FetchType.LAZY)
    private List<Account> lstAccount;

    public Role() {
    }

    public Role(String name, List<Account> lstAccount) {
        this.name = name;
        this.lstAccount = lstAccount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getLstAccount() {
        return lstAccount;
    }

    public void setLstAccount(List<Account> lstAccount) {
        this.lstAccount = lstAccount;
    }
}
