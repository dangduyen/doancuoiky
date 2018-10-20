package vn.hcmute.onlineshop.entity;

import javax.persistence.*;

@Entity(name = "chitietgiohang")
public class ChiTietGioHang {
   @EmbeddedId
    private ChiTietGioHang_Id id;
   private long so_luong;

}
