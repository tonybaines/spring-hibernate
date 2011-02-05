package masterclass.spring.example.developer;

public class JavaProgrammer implements Developer {

  @Override
  public String deliverCode() {
    return "CantSeeTheCodeForTheCatchBlocksException: caused by TooMuchCoffeeBeforeBedtime";
  }

}
