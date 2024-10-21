package com.ssndemo.ssn;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@RestController
@RequestMapping("/streamMessages")
public class StreamMessagesController {

    private final EventPublisherService eventPublisherService;

    @Autowired
    public StreamMessagesController(EventPublisherService eventPublisherService) {
        this.eventPublisherService = eventPublisherService;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
     @CrossOrigin(origins = "*")
    public Flux<String> streamMessages() {
        return eventPublisherService.getEvents();
    }
}