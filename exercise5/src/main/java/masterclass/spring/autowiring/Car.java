package masterclass.spring.autowiring;

public class Car extends CarPart {
  private final Chassis chassis;
  private final Engine engine;
  private final Body body;
  private final Interior interior;

  public Car(Chassis chassis, Engine engine, Body body, Interior interior) {
    this.chassis = chassis;
    this.engine = engine;
    this.body = body;
    this.interior = interior;
  }
}
