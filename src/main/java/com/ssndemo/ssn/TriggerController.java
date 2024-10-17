package com.ssndemo.ssn;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Sinks;

@RestController
public class TriggerController {

    private final Sinks.Many<String> sink;

    @Autowired
    public TriggerController(Sinks.Many<String> sink) {
        this.sink = sink;
    }

    @PostMapping("/api/checkin")
     @CrossOrigin(origins = "*")
    public void triggerSSE() {

        sink.tryEmitNext("Triggered at: " + LocalTime.now().toString()+ "Confirmation Number: "+"XSDAAASD345");
    }
}
