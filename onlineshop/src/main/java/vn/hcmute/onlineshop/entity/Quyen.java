package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "quyen")
public class Quyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ten_quyen;

    @ManyToMany(mappedBy = "lstQuyen",fetch = FetchType.LAZY)
    private List<TaiKhoan> lstTaiKhoan;

    public Quyen() {
    }

    public Quyen(String ten_quyen) {
        this.ten_quyen = ten_quyen;
    }

    public Quyen(String ten_quyen, List<TaiKhoan> lstTaiKhoan) {
        this.ten_quyen = ten_quyen;
        this.lstTaiKhoan = lstTaiKhoan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen_quyen() {
        return ten_quyen;
    }

    public void setTen_quyen(String ten_quyen) {
        this.ten_quyen = ten_quyen;
    }

    public List<TaiKhoan> getLstTaiKhoan() {
        return lstTaiKhoan;
    }

    public void setLstTaiKhoan(List<TaiKhoan> lstTaiKhoan) {
        this.lstTaiKhoan = lstTaiKhoan;
    }
}
