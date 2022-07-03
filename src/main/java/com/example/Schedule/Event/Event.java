package com.example.Schedule.Event;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time_of_event;

    public Event() {
    }

    public Event(Integer id, LocalDateTime time_of_event) {
        this.id = id;
        this.time_of_event = time_of_event;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getTime_of_event() {
        return time_of_event;
    }

    public void setTime_of_event(LocalDateTime time_of_event) {
        this.time_of_event = time_of_event;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", time_of_event=" + time_of_event +
                '}';
    }
}
