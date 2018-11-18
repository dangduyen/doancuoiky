package vn.hcmute.onlineshop.service;

import vn.hcmute.onlineshop.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents(String keyword);
}
