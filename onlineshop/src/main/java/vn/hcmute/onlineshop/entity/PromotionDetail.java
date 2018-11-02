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
}
