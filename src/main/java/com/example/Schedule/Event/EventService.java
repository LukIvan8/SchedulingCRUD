package com.example.Schedule.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService{
    @Autowired
    public EventRepository eventRepository;


    void createCurrent(Model model){
        LocalDateTime standardDate = LocalDateTime.now();
        System.out.println(standardDate);
        model.addAttribute("standardDate", standardDate);
    }
    void accessDates(Model model){
        List<Event> events = eventRepository.findAll();
        List<LocalDateTime> past_dates = new ArrayList<>();
        List<LocalDateTime> fut_dates = new ArrayList<>();
        List<LocalDateTime> one_dates = new ArrayList<>();
        List<LocalDateTime> three_dates = new ArrayList<>();
        List<LocalDateTime> seven_dates = new ArrayList<>();
        LocalDateTime current = (LocalDateTime) model.getAttribute("standardDate");
        System.out.println(current);
        for (Event event:events){
            LocalDateTime date = event.getTime_of_event();
            assert current != null;
            if (date.isBefore(current)){
                past_dates.add(date);
            } else if (date.isAfter(current)) {
                fut_dates.add(date);
                if(date.isAfter(current.plusDays(1)) && date.isBefore(current.plusDays(3))){
                    one_dates.add(date);
                } else if (date.isAfter(current.plusDays(3)) && date.isBefore(current.plusDays(7))) {
                    three_dates.add(date);
                } else if (date.isAfter(current.plusDays(7))) {
                    seven_dates.add(date);
                }
            }
        }
        model.addAttribute("past_dates", past_dates);
        model.addAttribute("future_dates", fut_dates);
        model.addAttribute("one_dates", one_dates);
        model.addAttribute("three_dates", three_dates);
        model.addAttribute("seven_dates", seven_dates);
    }
}
