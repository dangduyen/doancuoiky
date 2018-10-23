package vn.hcmute.onlineshop.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "bill_details")
public class BillDetail {
    @EmbeddedId
    private BillDetail_id id;
    private long quantity;
    private float price;
}
