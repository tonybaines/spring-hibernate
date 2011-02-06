package masterclass.spring.example.aop;

import java.util.Random;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class DeveloperLogging {
  public void logBeforeStart() {
    System.out.println("LOG: Danger- developer at work");
  }
  
  public void logWhenDone() {
    System.out.println("LOG: All done.  Time for a pot of coffee");
  }
  
  public Object timeTracker(ProceedingJoinPoint pjp) throws Throwable {
    StopWatch timer = new StopWatch();
    timer.start();
    
    randomWait(); // Just so that the timing results are interesting
    
    Object result = pjp.proceed();
    timer.stop();
    System.out.println("TIMER: Developer took " + timer.getLastTaskTimeMillis() + " ms");
    return result;
  }

  private void randomWait() {
    try {
      Thread.sleep(new Random().nextInt(1000));
    } catch (InterruptedException e) {/*Ignored*/}
  }
}