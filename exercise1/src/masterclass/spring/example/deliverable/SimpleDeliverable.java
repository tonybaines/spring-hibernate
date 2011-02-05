package masterclass.spring.example.deliverable;

import masterclass.spring.example.developer.Developer;

public class SimpleDeliverable implements Deliverable {
  
  private Developer developer;

  public SimpleDeliverable() {
  }

  @Override
  public String getPackagedCode() {
    return developer.deliverCode();
  }

}
