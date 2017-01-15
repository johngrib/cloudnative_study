package com.reservation.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties
@PropertySource("classpath:git.properties")
public class GitRepositoryState {

  Map<String, String> git;

  @Override
  public String toString() {
    return "GitRepositoryState{" +
            "git=" + git +
            '}';
  }
}
