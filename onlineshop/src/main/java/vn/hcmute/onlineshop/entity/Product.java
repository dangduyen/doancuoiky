package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private boolean status;
    private double price;
    private int quantity;

    @OneToMany(mappedBy = "id.product")
    private List<BillDetail> lstBillDetail;

    @OneToMany(mappedBy = "id.product")
    private  List<CartDetail> lstCartDetail;

    @OneToMany(mappedBy = "id.product")
    private  List<PromotionDetail> lstPromotionDetail;

    @ManyToMany(mappedBy = "lstProduct",fetch = FetchType.LAZY)
    private List<ProductList> lstProductList;

}
