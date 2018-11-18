package vn.hcmute.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmute.onlineshop.entity.Event;
import vn.hcmute.onlineshop.service.EventService;

import javax.persistence.*;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventService eventService;
    @PersistenceContext
    EntityManager em;
    @Override
    public List<Event> getAllEvents(String keyword) {
        StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_GetEvents",Event.class);
        query.registerStoredProcedureParameter(0,String.class, ParameterMode.IN);
        query.setParameter(0, keyword);
        query.execute();
        List<Event> events=query.getResultList();
        return events;
    }
}
