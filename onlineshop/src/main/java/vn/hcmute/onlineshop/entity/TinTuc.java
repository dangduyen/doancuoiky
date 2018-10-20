package vn.hcmute.onlineshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tintuc")
public class TinTuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String tua_de;
    private  String noi_dung;

    public TinTuc() {
    }

    public TinTuc(String tua_de, String noi_dung) {
        this.tua_de = tua_de;
        this.noi_dung = noi_dung;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTua_de() {
        return tua_de;
    }

    public void setTua_de(String tua_de) {
        this.tua_de = tua_de;
    }

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
    }
}
