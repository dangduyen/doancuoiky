package vn.hcmute.onlineshop.entity;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ChiTietKhuyenMai_Id implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private KhuyenMai khuyenmai;

    @ManyToOne(fetch = FetchType.LAZY)
    private SanPham sanpham;
}
