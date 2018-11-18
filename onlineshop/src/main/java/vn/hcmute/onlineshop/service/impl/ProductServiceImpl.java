package vn.hcmute.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmute.onlineshop.entity.Product;
import vn.hcmute.onlineshop.exception.NotFoundException;
import vn.hcmute.onlineshop.repository.ProductReponsitory;
import vn.hcmute.onlineshop.service.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductReponsitory productReponsitory;
    @PersistenceContext
    EntityManager em;
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

    @Override
    public List<Product> getAllProducts(String keyword) {
        StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_GetProducts", Product.class);
        query.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
        query.setParameter(0, keyword);
        query.execute();
        List<Product> products=query.getResultList();
        return products;
    }
}
