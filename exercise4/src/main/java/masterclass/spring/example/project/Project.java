package masterclass.spring.example.project;

import java.util.List;

import masterclass.spring.example.deliverable.Deliverable;


public class Project {
  private List<Deliverable> deliverables;
  
  protected Project() {} // Necessary when CGLIB AOP proxies are used (i.e. when no interface is available)

  public Project(List<Deliverable> deliverables) {
    this.deliverables = deliverables;
  }

  public String deliver() {
    StringBuilder retVal = new StringBuilder();

    for (Deliverable deliverable : deliverables) {
      retVal.append(deliverable.getPackagedCode());
      retVal.append("\n");
    }
    return retVal.toString();
  }
}
