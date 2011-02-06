import masterclass.spring.example.project.Project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
  public static void main(String[] args) {
    
    // The Spring definition file is in src/main/resources
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    
    Project simpleJavaProject = (Project) context.getBean("simpleJavaProject");
    Project complexJavaProject = (Project) context.getBean("complexJavaProject");
    Project complexMultiTechnologyProject = (Project) context.getBean("complexMultiTechnologyProject"); 

    System.out.println(simpleJavaProject.deliver());
    System.out.println(complexJavaProject.deliver());
    System.out.println(complexMultiTechnologyProject.deliver());
    
  }

}
