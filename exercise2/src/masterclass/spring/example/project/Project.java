package masterclass.spring.example.project;

import java.util.List;

import masterclass.spring.example.deliverable.Deliverable;


public class Project {
  private final List<Deliverable> deliverables;

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
