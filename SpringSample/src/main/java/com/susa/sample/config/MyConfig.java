package com.susa.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

  @Bean
  public MyBean myBean() {
    return new MyBean();
  }
}
