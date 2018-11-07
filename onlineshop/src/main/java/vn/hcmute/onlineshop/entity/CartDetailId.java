package vn.hcmute.onlineshop.entity;


import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class CartDetailId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    private  Product product;

    public CartDetailId() {
    }

    public CartDetailId(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
