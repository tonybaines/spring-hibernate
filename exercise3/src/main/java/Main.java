import masterclass.spring.example.project.Project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
  public static void main(String[] args) {
    
    // The Spring definition file is in src/main/resources
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Project simpleJavaProject = (Project) context.getBean("simpleJavaProject"); 
    
    System.out.println(simpleJavaProject.deliver());
    
    //
    // TODO: Extend the builder to assemble a variety of different projects
    //       e.g. complexJavaProject, complexMultiTechnologyProject, ...
    //       N.B. Make sure that developers can be reused between projects
    
  }

}
