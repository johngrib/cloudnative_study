package com.reservation;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ReservationApplication {

    @Bean
    GraphiteReporter graphite(@Value("${graphite.prefix}") String prefix,
                              @Value("${graphite.url}") String url,
                              @Value("${graphite.port}") int port,
                              MetricRegistry registry) {
        URL address;
        try {
            address = new URL(url);
            GraphiteReporter reporter = GraphiteReporter.forRegistry(registry)
                    .prefixedWith(prefix)
                    .build(new Graphite(address.getHost(), port));
            reporter.start(1, TimeUnit.SECONDS);
            return reporter;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);
    }
}

