package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    private List<Bill> lstBill;

    @OneToMany(mappedBy = "id.cart")
    private List<CartDetail> lstCartDetail;

    public Cart() {
    }

    public Cart(Customer customer, List<Bill> lstBill, List<CartDetail> lstCartDetail) {
        this.customer = customer;
        this.lstBill = lstBill;
        this.lstCartDetail = lstCartDetail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Bill> getLstBill() {
        return lstBill;
    }

    public void setLstBill(List<Bill> lstBill) {
        this.lstBill = lstBill;
    }

    public List<CartDetail> getLstCartDetail() {
        return lstCartDetail;
    }

    public void setLstCartDetail(List<CartDetail> lstCartDetail) {
        this.lstCartDetail = lstCartDetail;
    }
}
