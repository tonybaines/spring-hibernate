package masterclass.spring.example.deliverable;

import java.util.List;

import masterclass.spring.example.developer.Developer;

public class ComplexDeliverable implements Deliverable{
  private final List<Developer> team;

  public ComplexDeliverable(List<Developer> team) {
    this.team = team;
  }

  @Override
  public String getPackagedCode() {
    StringBuilder retVal = new StringBuilder();
    for (Developer developer : team) {
      retVal.append(developer.deliverCode());
      retVal.append("\n");
    }
    return retVal.toString();
  }
}
