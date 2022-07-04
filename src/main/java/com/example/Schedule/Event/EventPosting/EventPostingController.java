package com.example.Schedule.Event.EventPosting;

import com.example.Schedule.Event.Event;
import com.example.Schedule.Event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventPostingController {
    @Autowired
    public EventRepository eventRepository;

    @GetMapping("/admin")
    public String eventForm(Model model){
        Event event = new Event();
        model.addAttribute("event", event);
        return "admin";
    }
    @PostMapping("/admin")
    public String eventSubmit(@ModelAttribute Event event, Model model ){
        eventRepository.save(event);
        model.addAttribute(event);
        return "result";
    }
}
