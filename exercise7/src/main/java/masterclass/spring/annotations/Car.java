package masterclass.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car extends CarPart {
  private final Chassis chassis;
  private final Engine engine;
  private final Body body;
  private final Interior interior;

  @Autowired
  public Car(Chassis chassis, Engine engine, Body body, Interior interior) {
    this.chassis = chassis;
    this.engine = engine;
    this.body = body;
    this.interior = interior;
  }
}
