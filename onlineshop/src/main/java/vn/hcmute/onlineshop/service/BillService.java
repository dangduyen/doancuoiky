package vn.hcmute.onlineshop.service;

import vn.hcmute.onlineshop.entity.Bill;
import vn.hcmute.onlineshop.model.response.DataReturn;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface BillService {
    List<Bill> getAllBill(String keyword);
    DataReturn saveBill(Bill bill);
    DataReturn deleteBill (long id);
    DataReturn editBill(long id,Double total, Date payDate,String recipients);
    Bill findBillById(long id);
}
