package masterclass.spring.autowiring;

public class Interior extends CarPart {
  private final CupHolder cupHolder;
  private final CdPlayer cdPlayer;

  public Interior(CupHolder cupHolder, CdPlayer cdPlayer) {
    this.cupHolder = cupHolder;
    this.cdPlayer = cdPlayer;
  }
}
