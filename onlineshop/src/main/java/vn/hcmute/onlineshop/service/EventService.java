package vn.hcmute.onlineshop.service;

import vn.hcmute.onlineshop.entity.Event;
import vn.hcmute.onlineshop.model.response.DataReturn;

import java.util.Date;
import java.util.List;

public interface EventService {
    List<Event> getAllEvents(String keyword);
    DataReturn saveEvent(Event event);
    DataReturn deleteEvent(long id);
    DataReturn editEvent(long id, String name, String content, Date startDate, Date endDate);
    Event findEventById(long id);
}
