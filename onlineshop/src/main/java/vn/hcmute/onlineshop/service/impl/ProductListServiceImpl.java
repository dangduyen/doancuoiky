package vn.hcmute.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmute.onlineshop.entity.ProductList;
import vn.hcmute.onlineshop.exception.NotFoundException;
import vn.hcmute.onlineshop.repository.ProductListRepository;
import vn.hcmute.onlineshop.service.ProductListService;

import java.util.List;

@Service
public class ProductListServiceImpl implements ProductListService {

    @Autowired
    private ProductListRepository productListRepository;

    @Override
    public List<ProductList> retrieveAllProductList() {
        List<ProductList> productLists = productListRepository.findAll();
        if(productLists.isEmpty()) {
            throw new NotFoundException("No product list found!");
        }
        return productLists;
    }
}
