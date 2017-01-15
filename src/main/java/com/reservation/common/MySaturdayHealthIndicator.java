package com.reservation.common;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MySaturdayHealthIndicator implements HealthIndicator {
    public Health health() {
        try {
            RestTemplate rest = new RestTemplate();
            rest.getForObject("http://www.google.com", String.class);
            return Health.up().build();
        } catch (Exception e) {
            return Health.down().build();
        }
    }
}
