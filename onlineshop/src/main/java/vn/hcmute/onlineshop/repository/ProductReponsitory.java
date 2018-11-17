package vn.hcmute.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hcmute.onlineshop.entity.Product;

import java.util.Optional;

@Repository
public interface ProductReponsitory extends JpaRepository<Product,Long> {
    Optional<Product> findProductByNameAndStatusAndPriceAndQuantity(String name, boolean status, double price, int quantity);
    Optional<Product> findProductByName(String name);
}
