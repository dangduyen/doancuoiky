package vn.hcmute.onlineshop.entity;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class PromotionDetailId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private Promotion promotion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public PromotionDetailId() {
    }

    public PromotionDetailId(Promotion promotion, Product product) {
        this.promotion = promotion;
        this.product = product;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
