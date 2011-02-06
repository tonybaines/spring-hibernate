package masterclass.spring.example.developer;

public class JavaDeveloper implements Developer {

  @Override
  public String deliverCode() {
    return "CantSeeTheCodeForTheCatchBlocksException: caused by TooMuchCoffeeBeforeBedtime";
  }

}
