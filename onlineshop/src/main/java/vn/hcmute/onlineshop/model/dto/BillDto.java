package vn.hcmute.onlineshop.model.dto;

import java.io.Serializable;
import java.util.Date;

public class BillDto implements Serializable {
    private long id;
    private double total;
    private Date payDate;
    private String recipients;

    public BillDto() {
    }

    public BillDto(long id, double total, Date payDate, String recipients) {
        this.id = id;
        this.total = total;
        this.payDate = payDate;
        this.recipients = recipients;
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
}
