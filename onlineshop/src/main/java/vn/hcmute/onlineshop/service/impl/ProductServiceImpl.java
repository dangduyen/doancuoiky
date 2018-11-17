package vn.hcmute.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmute.onlineshop.entity.Product;
import vn.hcmute.onlineshop.exception.NotFoundException;
import vn.hcmute.onlineshop.repository.ProductReponsitory;
import vn.hcmute.onlineshop.service.ProductService;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductReponsitory productReponsitory;
    @Override
    public Product findProductByNameAndStatusAndPriceAndQuantity(String name, boolean status, double price, int quantity){
        Optional<Product> productOptional=productReponsitory.findProductByNameAndStatusAndPriceAndQuantity(name, status, price, quantity);
        if(productOptional.isPresent()){
            throw new NotFoundException("Not found Product");
        }
        return productOptional.get();
    }

    @Override
    public boolean findProductByName(String name) {
        Optional<Product> productOptional=productReponsitory.findProductByName(name);
        if(productOptional.isPresent()){
            return  true;
        }
        return false;
    }

    @Override
    public Product save(Product product) {
        return productReponsitory.save(product);
    }
}
