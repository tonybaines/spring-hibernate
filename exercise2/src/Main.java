import java.util.ArrayList;
import java.util.List;

import masterclass.spring.example.project.*;
import masterclass.spring.example.deliverable.*;
import masterclass.spring.example.developer.*;


public class Main {
  public static void main(String[] args) {
    Developer javaDeveloper = new JavaProgrammer();
    Deliverable javaDeliverable = new SimpleDeliverable(javaDeveloper);
    List<Deliverable> deliverables = new ArrayList<Deliverable>();
    deliverables.add(javaDeliverable);
    Project simpleProject = new Project(deliverables);

    //
    // TODO: Introduce a ProjectBuilder so that the next line works
    // Project simpleProject = new ProjectBuilder().getSimpleProject();
    
    System.out.println(simpleProject.deliver());
  }

}
