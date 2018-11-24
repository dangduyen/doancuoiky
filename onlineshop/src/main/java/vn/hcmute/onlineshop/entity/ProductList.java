package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "product_lists")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Sp_GetProductsList",
                procedureName = "Sp_GetProductsList",
                resultClasses = ProductList.class
        )
})
public class ProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int quantity;

    @ManyToMany
    @JoinTable(
            name = "prodcutlist_details",
            joinColumns = @JoinColumn(name = "id_productlist",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id")
    )
    private List<Product> lstProduct;

    public ProductList() {
    }

    public ProductList(String name, int quantity, List<Product> lstProduct) {
        this.name = name;
        this.quantity = quantity;
        this.lstProduct = lstProduct;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getLstProduct() {
        return lstProduct;
    }

    public void setLstProduct(List<Product> lstProduct) {
        this.lstProduct = lstProduct;
    }
}
