package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ten_khach_hang;
    private String dien_thoai;
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    private TaiKhoan taikhoan;

    @OneToOne(fetch = FetchType.LAZY)
    private GioHang giohang;

    @OneToMany(mappedBy = "khachhang")
    private List<HoaDon> lstHoaDon;
    public KhachHang() {
    }

    public KhachHang(String ten_khach_hang, String dien_thoai, String email) {
        this.ten_khach_hang = ten_khach_hang;
        this.dien_thoai = dien_thoai;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen_khach_hang() {
        return ten_khach_hang;
    }

    public void setTen_khach_hang(String ten_khach_hang) {
        this.ten_khach_hang = ten_khach_hang;
    }

    public String getDien_thoai() {
        return dien_thoai;
    }

    public void setDien_thoai(String dien_thoai) {
        this.dien_thoai = dien_thoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
