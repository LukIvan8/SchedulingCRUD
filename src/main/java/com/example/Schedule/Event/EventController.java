package com.example.Schedule.Event;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class EventController {
    @Autowired
    public EventRepository eventRepository;
    @Autowired
    public EventService eventService;

    @GetMapping
    public String displayALl(@NotNull Model model){
        eventService.createCurrent(model);
        eventService.accessDates(model);
        return "index";
    }
}
