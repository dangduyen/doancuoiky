package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "bills")
       @NamedStoredProcedureQueries({
               @NamedStoredProcedureQuery(
                       name = "Sp_GetBills",
                       procedureName = "Sp_GetBills",
                       resultClasses = Bill.class,
                       parameters = {
                               @StoredProcedureParameter(name = "keyword", mode = ParameterMode.IN, type = String.class)
                       }
               ),
               @NamedStoredProcedureQuery(
                       name = "Sp_AddBill",
                       procedureName = "Sp_AddBill",
                       resultClasses = Bill.class
               ),
               @NamedStoredProcedureQuery(
                       name = "Sp_DeleteBill",
                       procedureName = "Sp_DeleteBill",
                       resultClasses = Bill.class
               ),
               @NamedStoredProcedureQuery(
                       name = "Sp_EditBill",
                       procedureName = "Sp_EditBill",
                       resultClasses = Bill.class
               )
       })

public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double total;
    private Date payDate;
    private String recipients;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(mappedBy = "id.bill")
    private List<BillDetail> lstBillDetail;

    public Bill() {
    }

    public Bill(double total, Date payDate, String recipients, Cart cart, Customer customer, List<BillDetail> lstBillDetail) {
        this.total = total;
        this.payDate = payDate;
        this.recipients = recipients;
        this.cart = cart;
        this.customer = customer;
        this.lstBillDetail = lstBillDetail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<BillDetail> getLstBillDetail() {
        return lstBillDetail;
    }

    public void setLstBillDetail(List<BillDetail> lstBillDetail) {
        this.lstBillDetail = lstBillDetail;
    }
}
