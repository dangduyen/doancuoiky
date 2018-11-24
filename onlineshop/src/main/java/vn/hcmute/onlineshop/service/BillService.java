package vn.hcmute.onlineshop.service;

import vn.hcmute.onlineshop.entity.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getAllBill(String keyword);
}
