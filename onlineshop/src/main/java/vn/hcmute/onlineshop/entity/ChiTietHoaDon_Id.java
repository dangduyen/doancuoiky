package vn.hcmute.onlineshop.entity;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ChiTietHoaDon_Id implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private SanPham sanpham;

    @ManyToOne(fetch = FetchType.LAZY)
    private HoaDon hoadon;
}
