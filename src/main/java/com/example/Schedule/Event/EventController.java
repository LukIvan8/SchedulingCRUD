package com.example.Schedule.Event;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {
    @Autowired
    public EventRepository eventRepository;
    @Autowired
    public EventService eventService;

    @GetMapping("")
    public String displayALl(@NotNull Model model){
        Event event = new Event();
        model.addAttribute("event", event);
        eventService.createCurrent(model);
        eventService.accessDates(model);
        return "index";
    }

    @PostMapping("/deleteEvent")
    public String deleteEvent(@RequestParam("id") int id){
        System.out.println("Button reached");
        eventRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/addEvent")
    public String eventSubmit(@ModelAttribute Event event, Model model ) {
        eventRepository.save(event);
        model.addAttribute(event);
        return "redirect:/";
    }
}
