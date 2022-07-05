package com.example.Schedule.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    @Autowired
    public EventRepository eventRepository;


    void createCurrent(Model model) {
        LocalDateTime standardDate = LocalDateTime.now();
        System.out.println(standardDate);
        model.addAttribute("standardDate", standardDate);
    }

    void accessDates(Model model) {
        List<Event> events = eventRepository.findAll();
        List<Event> fut_dates = new ArrayList<>();
        List<Event> exp_dates = new ArrayList<>();
        LocalDateTime current = (LocalDateTime) model.getAttribute("standardDate");
        System.out.println(current);
        for (Event event : events) {
            LocalDateTime date = event.getTime_of_event();
            assert current != null;
            if (date.isAfter(current)) {
                fut_dates.add(event);
            } else if (date.isBefore(current)) {
                eventRepository.delete(event);
            }
        }

        model.addAttribute("future_dates", fut_dates);

    }

}
