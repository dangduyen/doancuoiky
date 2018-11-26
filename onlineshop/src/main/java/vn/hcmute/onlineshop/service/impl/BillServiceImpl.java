package vn.hcmute.onlineshop.service.impl;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import vn.hcmute.onlineshop.entity.Bill;
import vn.hcmute.onlineshop.entity.Event;
import vn.hcmute.onlineshop.exception.NotFoundException;
import vn.hcmute.onlineshop.model.dto.BillDto;
import vn.hcmute.onlineshop.model.response.DataReturn;
import vn.hcmute.onlineshop.repository.BillRepository;
import vn.hcmute.onlineshop.service.BillService;

import javax.persistence.*;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BillServiceImpl implements BillService {
    @PersistenceContext
    EntityManager em;
    @Autowired
    private BillRepository billRepository;
    @Override
    public List<Bill> getAllBill(String keyword) {
        StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_GetBills", Bill.class);
        query.registerStoredProcedureParameter(0,String.class, ParameterMode.IN);
        query.setParameter(0,keyword);
        query.execute();
        List<Bill> bills=query.getResultList();
        return bills;
    }

    @Override
    public DataReturn saveBill(Bill bill) {
        StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_AddBill",Bill.class);
        query.registerStoredProcedureParameter(0,Double.class,ParameterMode.IN);
        query.setParameter(0,bill.getTotal());
        query.registerStoredProcedureParameter(1, Date.class,ParameterMode.IN);
        query.setParameter(1, bill.getPayDate());
        query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
        query.setParameter(2,bill.getRecipients());
        DataReturn dataReturn=new DataReturn();
        try {
            query.execute();
            dataReturn.setSuccess("true");
        } catch (Exception ex) {
            dataReturn.setError(ex.getMessage());
            dataReturn.setSuccess("false");
        }
        return dataReturn;
    }

    @Override
    public DataReturn deleteBill(long id) {
        StoredProcedureQuery query= em.createStoredProcedureQuery("Sp_DeleteBill",Bill.class);
        query.registerStoredProcedureParameter(0,Long.class,ParameterMode.IN);
        query.setParameter(0,id);
        DataReturn dataReturn=new DataReturn();
        try{
            query.execute();
            dataReturn.setSuccess("true");
            List<Bill> bills=getAllBill("");
            List<BillDto> billDtos=bills.stream()
                    .map(bill -> new BillDto(bill.getId(),bill.getTotal(),bill.getPayDate(),bill.getRecipients()))
                    .collect(Collectors.toList());
            dataReturn.setData(billDtos);
        }catch (Exception ex){
            dataReturn.setError(ex.getMessage());
            dataReturn.setSuccess("false");
        }
        return dataReturn;
    }

    @Override
    public DataReturn editBill(long id, Double total, Date payDate, String recipients) {
       StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_EditBill",Bill.class);
       query.registerStoredProcedureParameter(0,Long.class,ParameterMode.IN);
       query.setParameter(0,id);
        query.registerStoredProcedureParameter(1,Double.class,ParameterMode.IN);
        query.setParameter(1,total);
       query.registerStoredProcedureParameter(2,Date.class,ParameterMode.IN);
       query.setParameter(2,payDate);
       query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
       query.setParameter(3,recipients);

        DataReturn dataReturn = new DataReturn();
        try {
            query.execute();
            dataReturn.setSuccess("true");
        } catch (Exception ex) {
            dataReturn.setError(ex.getMessage());
            dataReturn.setSuccess("false");
        }
        return dataReturn;
    }

    @Override
    public Bill findBillById(long id) {
        Optional<Bill> optionalBill=billRepository.findBillById(id);
        if(!optionalBill.isPresent()){
            throw new NotFoundException("Not found product");
        }
        return optionalBill.get();
    }
}
