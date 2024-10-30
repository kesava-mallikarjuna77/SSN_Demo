package com.ssndemo.ssn;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Sinks;


@RestController
@RequestMapping("/check-in")
public class CheckInController {
    
    private final EventPublisherService eventPublisherService;
    
    @Autowired
    public CheckInController(EventPublisherService eventPublisherService) {
        this.eventPublisherService = eventPublisherService;
    }
    
    @PostMapping
    //@CrossOrigin(origins = "*")
    public ResponseEntity<String> checkIn(@RequestBody String message) {
        eventPublisherService.publishEvent(message);
        return ResponseEntity.ok("Check-in successful and event published.");
    }
}