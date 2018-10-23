package vn.hcmute.onlineshop.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "promotion_details")
public class PromotionDetail {
    @EmbeddedId
    PromotionDetali_id id;
    private Date start_date;
    private Date end_date;
}
