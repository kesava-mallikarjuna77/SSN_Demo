
package com.ssndemo.ssn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import java.time.LocalTime;
import java.time.Duration;

@RestController
public class EventStreamController {

    private final Sinks.Many<String> sink;

    public EventStreamController(Sinks.Many<String> sink) {
        this.sink = sink;
    }

    @GetMapping(value = "/api/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamEvents() {
        return sink.asFlux().map(data -> "checkedinformation : " + data + "\n\n");
    }
}
