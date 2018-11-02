package vn.hcmute.onlineshop.entity;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class PromotionDetailId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private Promotion promotion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}