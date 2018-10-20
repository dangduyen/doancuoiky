package vn.hcmute.onlineshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "sukien")
public class SuKien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ten_su_kien;
    private String noi_dung;
    private Date ngay_bat_dau;
    private Date ngay_ket_thuc;

    public SuKien() {
    }

    public SuKien(String ten_su_kien, String noi_dung, Date ngay_bat_dau, Date ngay_ket_thuc) {
        this.ten_su_kien = ten_su_kien;
        this.noi_dung = noi_dung;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen_su_kien() {
        return ten_su_kien;
    }

    public void setTen_su_kien(String ten_su_kien) {
        this.ten_su_kien = ten_su_kien;
    }

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
    }

    public Date getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(Date ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public Date getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(Date ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }
}
