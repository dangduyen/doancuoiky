package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "hoadon")

public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double tong_tien;
    private Date ngay_thanh_toan;
    private String noi_nhan;

    @ManyToOne(fetch = FetchType.LAZY)
    private GioHang giohang;

    @ManyToOne(fetch = FetchType.LAZY)
    private KhachHang khachhang;

    @OneToMany(mappedBy = "id.hoadon")
    private List<ChiTietHoaDon> lstChiTietHoaDon;
    public HoaDon() {
    }

    public HoaDon( double tong_tien, Date ngay_thanh_toan, String noi_nhan) {

        this.tong_tien = tong_tien;
        this.ngay_thanh_toan = ngay_thanh_toan;
        this.noi_nhan = noi_nhan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(double tong_tien) {
        this.tong_tien = tong_tien;
    }

    public Date getNgay_thanh_toan() {
        return ngay_thanh_toan;
    }

    public void setNgay_thanh_toan(Date ngay_thanh_toan) {
        this.ngay_thanh_toan = ngay_thanh_toan;
    }

    public String getNoi_nhan() {
        return noi_nhan;
    }

    public void setNoi_nhan(String noi_nhan) {
        this.noi_nhan = noi_nhan;
    }
}
