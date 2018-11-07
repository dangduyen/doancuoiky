package vn.hcmute.onlineshop.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "cart_details")
public class CartDetail {
    @EmbeddedId
    private CartDetailId id;
    private long quantity;

    public CartDetail() {
    }

    public CartDetail(CartDetailId id, long quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public CartDetailId getId() {
        return id;
    }

    public void setId(CartDetailId id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
