package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    private Account account;

    @OneToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @OneToMany(mappedBy = "customer")
    private List<Bill> lstBill;

    public Customer() {
    }

    public Customer(String name, String phone, String email, Account account, Cart cart, List<Bill> lstBill) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.account = account;
        this.cart = cart;
        this.lstBill = lstBill;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Bill> getLstBill() {
        return lstBill;
    }

    public void setLstBill(List<Bill> lstBill) {
        this.lstBill = lstBill;
    }
}
