package vn.hcmute.onlineshop.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "chitiethoadon")
public class ChiTietHoaDon {
    @EmbeddedId
    private ChiTietHoaDon_Id id;
    private long so_luong;
    private float gia_sp;
}
