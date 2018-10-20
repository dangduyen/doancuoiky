package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "khuyenmai")
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ten_km;
    private float phan_tram_km;

    @OneToMany(mappedBy = "id.khuyenmai")
    private List<ChiTietKhuyenMai> lstChiTietKhuyenMai;

    public KhuyenMai() {
    }

    public KhuyenMai(String ten_km, float phan_tram_km) {
        this.ten_km = ten_km;
        this.phan_tram_km = phan_tram_km;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen_km() {
        return ten_km;
    }

    public void setTen_km(String ten_km) {
        this.ten_km = ten_km;
    }

    public float getPhan_tram_km() {
        return phan_tram_km;
    }

    public void setPhan_tram_km(float phan_tram_km) {
        this.phan_tram_km = phan_tram_km;
    }
}
