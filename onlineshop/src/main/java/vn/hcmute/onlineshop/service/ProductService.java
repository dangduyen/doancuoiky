package vn.hcmute.onlineshop.service;

import vn.hcmute.onlineshop.entity.Product;
import vn.hcmute.onlineshop.model.response.DataReturn;

import java.util.List;

public interface ProductService {
    Product findProductByNameAndStatusAndPriceAndQuantity(String name, boolean status, double price, int quantity);
    boolean findProductByName (String name);
    DataReturn saveProduct(Product product, long productListId);
    List<Product> getAllProducts(String keyword);
    DataReturn deleteProduct(long id);
    DataReturn editProduct(long id, String name, float price, int quantity, boolean status);
    Product findProductById(long id);
}

