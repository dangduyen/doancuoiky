package vn.hcmute.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hcmute.onlineshop.entity.Bill;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill,Long> {
    Optional<Bill> findBillById(long id);
}
