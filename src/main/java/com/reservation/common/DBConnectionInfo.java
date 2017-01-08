package com.reservation.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class DBConnectionInfo {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String schema;

}