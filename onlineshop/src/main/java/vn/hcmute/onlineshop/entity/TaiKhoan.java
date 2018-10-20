package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "taikhoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ten_dang_nhap;
    private String mat_khau;

    @ManyToMany
    @JoinTable(
            name = "taikhoan_quyen",
            joinColumns = @JoinColumn(name = "id_tai_khoan", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_quyen",referencedColumnName = "id")
    )
    private List<Quyen> lstQuyen;

    @OneToOne(fetch = FetchType.LAZY)
    private KhachHang user;

    @OneToMany(mappedBy = "taikhoan")
    private List<LichSu> lstLichSu;
    public TaiKhoan() {
    }

    public TaiKhoan(String ten_dang_nhap, String mat_khau) {
        this.ten_dang_nhap = ten_dang_nhap;
        this.mat_khau = mat_khau;
    }

    public TaiKhoan(String ten_dang_nhap, String mat_khau, List<Quyen> lstQuyen) {
        this.ten_dang_nhap = ten_dang_nhap;
        this.mat_khau = mat_khau;
        this.lstQuyen = lstQuyen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen_dang_nhap() {
        return ten_dang_nhap;
    }

    public void setTen_dang_nhap(String ten_dang_nhap) {
        this.ten_dang_nhap = ten_dang_nhap;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public List<Quyen> getLstQuyen() {
        return lstQuyen;
    }

    public void setLstQuyen(List<Quyen> lstQuyen) {
        this.lstQuyen = lstQuyen;
    }
}
