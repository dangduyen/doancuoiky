package vn.hcmute.onlineshop.service;

import vn.hcmute.onlineshop.entity.Product;

public interface ProductService {
    Product findProductByNameAndStatusAndPriceAndQuantity(String name, boolean status, double price, int quantity);
    boolean findProductByName (String name);
    Product save(Product product);
}

