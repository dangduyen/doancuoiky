package vn.hcmute.onlineshop.entity;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class BillDetailId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Bill bill;
}
