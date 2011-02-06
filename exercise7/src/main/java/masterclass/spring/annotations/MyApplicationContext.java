package masterclass.spring.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyApplicationContext {
  @Bean public Car getCar(){
    return new Car(chassis(), engine(), body(), interior());
  }

  @Bean public Interior interior() {
    return new Interior(cupHolder(), cdPlayer());
  }

  private CdPlayer cdPlayer() {
    return new CdPlayer();
  }

  private CupHolder cupHolder() {
    return new CupHolder();
  }

  @Bean public Body body() {
    return new Body();
  }

  @Bean public Engine engine() {
    return new Engine();
  }

  @Bean public Chassis chassis() {
    return new Chassis(wheel(), wheel(), wheel(), wheel());
  }

  @Bean public Wheel wheel() {
    return new Wheel();
  }
}
