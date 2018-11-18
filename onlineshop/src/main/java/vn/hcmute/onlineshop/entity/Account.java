package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "accounts")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Sp_GetAccounts",
                procedureName = "Sp_GetAccounts",
                resultClasses = Account.class,
                parameters = {
                        @StoredProcedureParameter(name = "keyword", mode = ParameterMode.IN, type = String.class)
                }
        )
})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
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

    public Account() {
    }

    public Account(String username, String password, List<Role> lstRole, Customer customer, List<History> lstHistory) {
        this.username = username;
        this.password = password;
        this.lstRole = lstRole;
        this.customer = customer;
        this.lstHistory = lstHistory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getLstRole() {
        return lstRole;
    }

    public void setLstRole(List<Role> lstRole) {
        this.lstRole = lstRole;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<History> getLstHistory() {
        return lstHistory;
    }

    public void setLstHistory(List<History> lstHistory) {
        this.lstHistory = lstHistory;
    }


}
