import masterclass.spring.annotations.Car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
  public static void main(String[] args) {
    
    // The Spring definition file is in src/main/resources
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    context.getBean(Car.class);
    
    // TODO: Use the same annotations as in Car.java to declare and autowire the other classes 
  }

}
