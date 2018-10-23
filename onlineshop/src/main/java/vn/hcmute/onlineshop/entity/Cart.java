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
}
