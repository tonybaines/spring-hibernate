import java.util.ArrayList;
import java.util.List;

import masterclass.spring.example.project.*;
import masterclass.spring.example.deliverable.*;
import masterclass.spring.example.developer.*;


public class Main {
  public static void main(String[] args) {
    Developer developer1 = new JavaProgrammer();
    Deliverable deliverable1 = new SimpleDeliverable(developer1);
    List<Deliverable> deliverables = new ArrayList<Deliverable>();
    deliverables.add(deliverable1);
    Project project1 = new Project(deliverables);
    
    System.out.println(project1.deliver());
  }

}
