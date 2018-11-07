package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private float percent;

    @OneToMany(mappedBy = "id.promotion")
    private List<PromotionDetail> lstPromotionsDetail;

    public Promotion() {
    }

    public Promotion(String name, float percent, List<PromotionDetail> lstPromotionsDetail) {
        this.name = name;
        this.percent = percent;
        this.lstPromotionsDetail = lstPromotionsDetail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public List<PromotionDetail> getLstPromotionsDetail() {
        return lstPromotionsDetail;
    }

    public void setLstPromotionsDetail(List<PromotionDetail> lstPromotionsDetail) {
        this.lstPromotionsDetail = lstPromotionsDetail;
    }
}
