package vn.hcmute.onlineshop.entity;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class BillDetailId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Bill bill;

    public BillDetailId() {
    }

    public BillDetailId(Product product, Bill bill) {
        this.product = product;
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
