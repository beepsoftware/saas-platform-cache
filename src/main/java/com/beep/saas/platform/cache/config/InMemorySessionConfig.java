package com.beep.saas.platform.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.session.MapSessionRepository;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;



@Configuration
@Profile("!redis")
public class InMemorySessionConfig {

    @Bean
    public MapSessionRepository sessionRepository() {
        MapSessionRepository repo = new MapSessionRepository(new ConcurrentHashMap<>());
        repo.setDefaultMaxInactiveInterval(Duration.ofMinutes(30));
        return repo;
    }
}
