package masterclass.spring.example.deliverable;

import masterclass.spring.example.developer.Developer;

public class SimpleDeliverable implements Deliverable {
  
  private final Developer developer;

  public SimpleDeliverable(Developer developer) {
    this.developer = developer;
  }

  @Override
  public String getPackagedCode() {
    return developer.deliverCode();
  }

}
