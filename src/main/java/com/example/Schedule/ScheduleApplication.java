package com.example.Schedule;

import com.example.Schedule.Event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class ScheduleApplication {
	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

}

