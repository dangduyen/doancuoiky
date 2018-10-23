package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double total;
    private Date pay_date;
    private String recipients;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(mappedBy = "id.bill")
    private List<BillDetail> lstBillDetail;
}
