package vn.hcmute.onlineshop.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "cart_details")
public class CartDetail {
    @EmbeddedId
    private CartDetailId id;
    private long quantity;
}
