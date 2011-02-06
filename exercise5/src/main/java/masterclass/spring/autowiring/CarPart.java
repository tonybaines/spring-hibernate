package masterclass.spring.autowiring;

public abstract class CarPart {
  public CarPart() {
    System.out.println("Built: " + this.getClass().getSimpleName());
  }
}
