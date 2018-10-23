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
}
