import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
  public static void main(String[] args) {
    
    // The Spring definition file is in src/main/resources
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    context.getBean("car");
    
    // TODO: Declare and autowire the other classes in src/main/resources/applicationContext.xml
  }

}
