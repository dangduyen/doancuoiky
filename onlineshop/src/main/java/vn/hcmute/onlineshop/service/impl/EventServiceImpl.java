package vn.hcmute.onlineshop.service.impl;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmute.onlineshop.entity.Event;
import vn.hcmute.onlineshop.exception.NotFoundException;
import vn.hcmute.onlineshop.model.dto.EventDto;
import vn.hcmute.onlineshop.model.response.DataReturn;
import vn.hcmute.onlineshop.repository.EventRepository;
import vn.hcmute.onlineshop.service.EventService;

import javax.persistence.*;
import java.awt.dnd.DropTarget;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepository eventRepository;
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

    @Override
    public DataReturn saveEvent(Event event) {
        StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_AddEvent",Event.class);
        query.registerStoredProcedureParameter(0,String.class,ParameterMode.IN);
        query.setParameter(0,event.getName());
        query.registerStoredProcedureParameter(1,String.class, ParameterMode.IN);
        query.setParameter(1,event.getContent());
        query.registerStoredProcedureParameter(2, Date.class,ParameterMode.IN);
        query.setParameter(2,event.getStartDate());
        query.registerStoredProcedureParameter(3, Date.class,ParameterMode.IN);
        query.setParameter(3,event.getEndDate());
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
    public DataReturn deleteEvent(long id) {
    StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_DeleteEvent",Event.class);
    query.registerStoredProcedureParameter(0,Long.class,ParameterMode.IN);
    query.setParameter(0,id);
    DataReturn dataReturn=new DataReturn();
    try{
        query.execute();
        dataReturn.setSuccess("true");
        List<Event> events=getAllEvents("");
        List<EventDto> eventDtos=events.stream()
                .map(event -> new EventDto(event.getId(), event.getName(),event.getContent(), event.getStartDate(), event.getEndDate()))
                .collect(Collectors.toList());
        dataReturn.setData(eventDtos);
    }catch (Exception ex){
        dataReturn.setError(ex.getMessage());
        dataReturn.setSuccess("false");
    }
    return  dataReturn;
    }

    @Override
    public DataReturn editEvent(long id, String name, String content, Date startDate, Date endDate) {
        StoredProcedureQuery query=em.createStoredProcedureQuery("Sp_EditEvent",Event.class);
        query.registerStoredProcedureParameter(0,Long.class,ParameterMode.IN);
        query.setParameter(0,id);
        query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
        query.setParameter(1,name);
        query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
        query.setParameter(2,content);
        query.registerStoredProcedureParameter(3, Date.class,ParameterMode.IN);
        query.setParameter(3,startDate);
        query.registerStoredProcedureParameter(4, Date.class,ParameterMode.IN);
        query.setParameter(4,endDate);
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
    public Event findEventById(long id) {
        Optional<Event> eventOptional=eventRepository.findEventById(id);
        if(!eventOptional.isPresent()){
            throw new NotFoundException("Not found product");
        }
        return eventOptional.get();
    }

}
