package vn.hcmute.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmute.onlineshop.entity.Product;
import vn.hcmute.onlineshop.exception.NotFoundException;
import vn.hcmute.onlineshop.model.dto.ProductDto;
import vn.hcmute.onlineshop.model.response.DataReturn;
import vn.hcmute.onlineshop.repository.ProductReponsitory;
import vn.hcmute.onlineshop.service.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public DataReturn saveProduct(Product product, long productListId) {
        StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_AddProduct", Product.class);
        query.registerStoredProcedureParameter(0, String.class,ParameterMode.IN);
        query.setParameter(0, product.getName());
        query.registerStoredProcedureParameter(1, double.class,ParameterMode.IN);
        query.setParameter(1,product.getPrice());
        query.registerStoredProcedureParameter(2,int.class,ParameterMode.IN);
        query.setParameter(2, product.getQuantity());
        query.registerStoredProcedureParameter(3,boolean.class,ParameterMode.IN);
        query.setParameter(3, product.isStatus());
        query.registerStoredProcedureParameter(4,long.class,ParameterMode.IN);
        query.setParameter(4,productListId);
        DataReturn dataReturn = new DataReturn();
        try {
            query.execute();
            dataReturn.setData(product);
            dataReturn.setSuccess("true");
        } catch (Exception ex) {
            dataReturn.setError(ex.getMessage());
            dataReturn.setSuccess("false");
        }
        return dataReturn;
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

    @Override
    public DataReturn deleteProduct(long id) {
        StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_DeleteProduct", Product.class);
        query.registerStoredProcedureParameter(0,Long.class, ParameterMode.IN);
        query.setParameter(0,id);
        DataReturn dataReturn=new DataReturn();
        try {
            query.execute();
            dataReturn.setSuccess("true");
            List<Product> products = getAllProducts("");
            List<ProductDto> productDtos=products.stream()
                    .map(product -> new ProductDto(product.getId(),product.getName(),product.getPrice(), product.getQuantity(),product.isStatus()))
                    .collect(Collectors.toList());
            dataReturn.setData(productDtos);
        }
        catch (Exception ex){
            dataReturn.setError(ex.getMessage());
            dataReturn.setSuccess("false");
        }
        return dataReturn;
    }

    @Override
    public DataReturn editProduct(long id, String name, float price, int quantity, boolean status) {
        StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_EditProduct",Product.class);
        query.registerStoredProcedureParameter(0, Long.class,ParameterMode.IN);
        query.setParameter(0, id);
        query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
        query.setParameter(1,name);
        query.registerStoredProcedureParameter(2, Float.class,ParameterMode.IN);
        query.setParameter(2,price);
        query.registerStoredProcedureParameter(3,int.class,ParameterMode.IN);
        query.setParameter(3, quantity);
        query.registerStoredProcedureParameter(4,boolean.class,ParameterMode.IN);
        query.setParameter(4, status);
        DataReturn dataReturn = new DataReturn();
        try {
            query.execute();
            dataReturn.setSuccess("true");
        } catch (Exception ex) {
            dataReturn.setError(ex.getMessage());
            dataReturn.setSuccess("false");
        }
        return dataReturn;
    }

    @Override
    public Product findProductById(long id) {
        Optional<Product> productOptional=productReponsitory.findProductById(id);
        if(!productOptional.isPresent()){
            throw new NotFoundException("Not found product");
        }
        return productOptional.get();
    }
}
