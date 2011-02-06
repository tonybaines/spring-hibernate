import masterclass.spring.annotations.Car;
import masterclass.spring.annotations.MyApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
  public static void main(String[] args) {
    
    // No XML!
    ApplicationContext context = new AnnotationConfigApplicationContext(MyApplicationContext.class);
    context.getBean(Car.class);
  }

}
