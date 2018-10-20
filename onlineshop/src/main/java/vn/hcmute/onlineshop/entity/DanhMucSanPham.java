package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "danhmucsanpham")
public class DanhMucSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ten_dmsp;
    private int so_luong;

    @ManyToMany
    @JoinTable(
            name = "chitietdanhmucsanpham",
            joinColumns = @JoinColumn(name = "id_danh_muc",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_san_pham", referencedColumnName = "id")
    )
    private List<SanPham> lstsanpham;
    public DanhMucSanPham() {
    }

    public DanhMucSanPham(String ten_dmsp, int so_luong) {
        this.ten_dmsp = ten_dmsp;
        this.so_luong = so_luong;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen_dmsp() {
        return ten_dmsp;
    }

    public void setTen_dmsp(String ten_dmsp) {
        this.ten_dmsp = ten_dmsp;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }
}
