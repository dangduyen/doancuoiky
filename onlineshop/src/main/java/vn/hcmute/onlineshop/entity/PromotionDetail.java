package vn.hcmute.onlineshop.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "promotion_details")
public class PromotionDetail {
    @EmbeddedId
    PromotionDetailId id;
    private Date startDate;
    private Date endDate;

    public PromotionDetail() {
    }

    public PromotionDetail(PromotionDetailId id, Date startDate, Date endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public PromotionDetailId getId() {
        return id;
    }

    public void setId(PromotionDetailId id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
