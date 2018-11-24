package vn.hcmute.onlineshop.service.impl;

import org.springframework.stereotype.Service;
import vn.hcmute.onlineshop.entity.ProductList;
import vn.hcmute.onlineshop.service.ProductListService;
import vn.hcmute.onlineshop.service.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class ProductListServiceImpl implements ProductListService {
    @PersistenceContext
    EntityManager em;
    @Override
    public List<ProductList> getAllProductList() {
        StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_GetProductsList",ProductList.class);
        query.execute();
        List<ProductList> productLists=query.getResultList();
        return productLists;
    }
}
