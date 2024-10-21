package com.ssndemo.ssn;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class EventPublisherService {
    private final Sinks.Many<String> sink;

    @Autowired
    public EventPublisherService() {
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void publishEvent(String event) {
        this.sink.tryEmitNext(event);
    }

    public Flux<String> getEvents() {
        return this.sink.asFlux();
    }
}
