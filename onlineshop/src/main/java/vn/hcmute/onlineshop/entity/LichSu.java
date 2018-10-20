package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name="lichsu")
public class LichSu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date thoi_gian_dang_nhap;
    private Date thoi_gian_dang_xuat;

    @ManyToOne(fetch = FetchType.LAZY)
    private TaiKhoan taikhoan;
    public LichSu() {
    }

    public LichSu(Date thoi_gian_dang_nhap, Date thoi_gian_dang_xuat) {
        this.thoi_gian_dang_nhap = thoi_gian_dang_nhap;
        this.thoi_gian_dang_xuat = thoi_gian_dang_xuat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getThoi_gian_dang_nhap() {
        return thoi_gian_dang_nhap;
    }

    public void setThoi_gian_dang_nhap(Date thoi_gian_dang_nhap) {
        this.thoi_gian_dang_nhap = thoi_gian_dang_nhap;
    }

    public Date getThoi_gian_dang_xuat() {
        return thoi_gian_dang_xuat;
    }

    public void setThoi_gian_dang_xuat(Date thoi_gian_dang_xuat) {
        this.thoi_gian_dang_xuat = thoi_gian_dang_xuat;
    }
}

