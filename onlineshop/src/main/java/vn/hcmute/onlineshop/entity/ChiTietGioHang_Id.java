package vn.hcmute.onlineshop.entity;


import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ChiTietGioHang_Id implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private GioHang giohang;

    @ManyToOne(fetch = FetchType.LAZY)
    private  SanPham sanpham;
}
