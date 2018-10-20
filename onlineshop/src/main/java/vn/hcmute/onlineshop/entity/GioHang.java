package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "giohang")
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    private KhachHang khachhang;

    @OneToMany(mappedBy = "giohang")
    private List<HoaDon> lstHoaDon;

    @OneToMany(mappedBy = "id.giohang")
    private List<ChiTietGioHang> lstChiTietGioHang;

    public GioHang() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
