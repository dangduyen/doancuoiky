package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String usename;
    private String password;
    @ManyToMany
    @JoinTable(
            name = "account_role",
            joinColumns = @JoinColumn(name = "id_account", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_role",referencedColumnName = "id")
    )
    private List<Role> lstRole;

    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(mappedBy = "account")
    private List<History> lstHistory;
}
