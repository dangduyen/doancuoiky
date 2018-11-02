package vn.hcmute.onlineshop.entity;


import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class CartDetailId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    private  Product product;
}
