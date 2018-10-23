package vn.hcmute.onlineshop.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "historys")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date login_date;
    private Date logout_date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;
}
