package io.github.grandlich.redpraisal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RedPraisalApplication {

  public static void main(String[] args) {
    SpringApplication.run(RedPraisalApplication.class, args);
  }

}
