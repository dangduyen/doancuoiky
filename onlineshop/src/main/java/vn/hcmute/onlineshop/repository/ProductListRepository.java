package vn.hcmute.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hcmute.onlineshop.entity.ProductList;

@Repository
public interface ProductListRepository extends JpaRepository<ProductList, Long> {
}
