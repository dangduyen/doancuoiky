package vn.hcmute.onlineshop.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "bill_details")
public class BillDetail {
    @EmbeddedId
    private BillDetailId id;
    private long quantity;
    private float price;

    public BillDetail() {
    }

    public BillDetail(BillDetailId id, long quantity, float price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public BillDetailId getId() {
        return id;
    }

    public void setId(BillDetailId id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
