package vn.hcmute.onlineshop.service.impl;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import vn.hcmute.onlineshop.entity.Bill;
import vn.hcmute.onlineshop.entity.Event;
import vn.hcmute.onlineshop.service.BillService;

import javax.persistence.*;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class BillServiceImpl implements BillService {
    @PersistenceContext
    EntityManager em;
    @Override
    public List<Bill> getAllBill(String keyword) {
        StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_GetBills", Bill.class);
        query.registerStoredProcedureParameter(0,String.class, ParameterMode.IN);
        query.setParameter(0,keyword);
        query.execute();
        List<Bill> bills=query.getResultList();
        return bills;
    }
}
