package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "products")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Sp_GetProducts",
                procedureName = "Sp_GetProducts",
                resultClasses = Product.class,
                parameters = {
                        @StoredProcedureParameter(name="keyword", mode = ParameterMode.IN, type = String.class)
                }
        )
})
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

//    @OneToMany(mappedBy = "id.product")
//    private  List<PromotionDetail> lstPromotionDetail;

    @ManyToMany(mappedBy = "lstProduct",fetch = FetchType.LAZY)
    private List<ProductList> lstProductList;

    public Product() {
    }

    public Product(String name, boolean status, double price, int quantity, List<BillDetail> lstBillDetail, List<CartDetail> lstCartDetail, List<ProductList> lstProductList) {
        this.name = name;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
        this.lstBillDetail = lstBillDetail;
        this.lstCartDetail = lstCartDetail;
        this.lstProductList = lstProductList;
    }

    //    public Product(String name, boolean status, double price, int quantity, List<BillDetail> lstBillDetail, List<CartDetail> lstCartDetail, List<PromotionDetail> lstPromotionDetail, List<ProductList> lstProductList) {
//        this.name = name;
//        this.status = status;
//        this.price = price;
//        this.quantity = quantity;
//        this.lstBillDetail = lstBillDetail;
//        this.lstCartDetail = lstCartDetail;
//        this.lstPromotionDetail = lstPromotionDetail;
//        this.lstProductList = lstProductList;
//    }

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<BillDetail> getLstBillDetail() {
        return lstBillDetail;
    }

    public void setLstBillDetail(List<BillDetail> lstBillDetail) {
        this.lstBillDetail = lstBillDetail;
    }

    public List<CartDetail> getLstCartDetail() {
        return lstCartDetail;
    }

    public void setLstCartDetail(List<CartDetail> lstCartDetail) {
        this.lstCartDetail = lstCartDetail;
    }

//    public List<PromotionDetail> getLstPromotionDetail() {
//        return lstPromotionDetail;
//    }
//
//    public void setLstPromotionDetail(List<PromotionDetail> lstPromotionDetail) {
//        this.lstPromotionDetail = lstPromotionDetail;
//    }

    public List<ProductList> getLstProductList() {
        return lstProductList;
    }

    public void setLstProductList(List<ProductList> lstProductList) {
        this.lstProductList = lstProductList;
    }
}
