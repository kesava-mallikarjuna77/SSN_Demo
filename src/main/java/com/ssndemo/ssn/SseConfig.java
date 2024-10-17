package com.ssndemo.ssn;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Sinks;

@Configuration
public class SseConfig {

    @Bean
    public Sinks.Many<String> sink() {
        return Sinks.many().multicast().onBackpressureBuffer();
    }
}
