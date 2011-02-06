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

  // TODO: Fill in the remaining definitions
  //       Again, remember to make Wheel a prototype
}
