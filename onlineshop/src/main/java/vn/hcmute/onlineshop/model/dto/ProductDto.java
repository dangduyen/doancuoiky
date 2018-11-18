package vn.hcmute.onlineshop.model.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
    private long id;
    private String name;
    private boolean status;
    private double price;
    private int quantity;

    public ProductDto(long id, String name, double price, int quantity, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductDto() {

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
}
