package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.zip.DataFormatException;

@Entity(name = "chitietkhuyenmai")
public class ChiTietKhuyenMai {
  @EmbeddedId ChiTietKhuyenMai_Id id;
  private Date thoi_gian_bat_dau;
  private Date thoi_gian_ket_thuc;

}
