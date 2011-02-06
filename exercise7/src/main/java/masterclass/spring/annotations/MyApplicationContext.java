package masterclass.spring.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class MyApplicationContext {
  @Bean public Car car(){
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

  @Bean @Scope("prototype") public Wheel wheel() {
    return new Wheel();
  }
}
