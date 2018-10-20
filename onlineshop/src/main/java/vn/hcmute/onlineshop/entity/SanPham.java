package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sanpham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ten_san_pham;
    private boolean trang_thai_km;
    private double gia;
    private int so_luong;

    @OneToMany(mappedBy = "id.sanpham")
    private List<ChiTietHoaDon> lstChiTietHoaDon;

    @OneToMany(mappedBy = "id.sanpham")
    private  List<ChiTietGioHang> lstChiTietGioHang;

    @OneToMany(mappedBy = "id.sanpham")
    private  List<ChiTietKhuyenMai> lstChiTietKhuyenMai;

    @ManyToMany(mappedBy = "lstsanpham",fetch = FetchType.LAZY)
    private List<DanhMucSanPham> lstDanhMuc;

    public SanPham() {
    }

    public SanPham(String ten_san_pham, boolean trang_thai_km, double gia, int so_luong) {
        this.ten_san_pham = ten_san_pham;
        this.trang_thai_km = trang_thai_km;
        this.gia = gia;
        this.so_luong = so_luong;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen_san_pham() {
        return ten_san_pham;
    }

    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
    }

    public boolean isTrang_thai_km() {
        return trang_thai_km;
    }

    public void setTrang_thai_km(boolean trang_thai_km) {
        this.trang_thai_km = trang_thai_km;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }
}
