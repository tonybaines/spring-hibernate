import java.util.ArrayList;
import java.util.List;

import masterclass.spring.example.project.*;
import masterclass.spring.example.deliverable.*;
import masterclass.spring.example.developer.*;


public class Main {
  public static void main(String[] args) {
    Developer javaDeveloper = new JavaDeveloper();
    Deliverable javaDeliverable = new SimpleDeliverable(javaDeveloper);
    List<Deliverable> deliverables = new ArrayList<Deliverable>();
    deliverables.add(javaDeliverable);
    Project simpleJavaProject = new Project(deliverables);

    //
    // TODO: Introduce a ProjectBuilder so that the next line works 
    //       (hint: just move the code above into the new class)
    // Project simpleJavaProject = new ProjectBuilder().getBean("simpleJavaProject"); 
    
    System.out.println(simpleJavaProject.deliver());
    
    //
    // TODO: Extend the builder to assemble a variety of different projects
    //       e.g. complexJavaProject, complexMultiTechnologyProject, ...
    //       N.B. Make sure that developers can be reused between projects
    
  }

}
