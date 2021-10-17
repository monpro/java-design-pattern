package com.monpro.designpattern.behavior.basic;

public class Demo {
  public static void main(String[] args) {
    final DemoSubject demoSubject = new DemoSubject();
    final DemoObserver demoObserver = new DemoObserver("Demo-Class-1");

    demoSubject.registerObserver(demoObserver);
    demoSubject.registerObserver(new DemoObserver("Demo-Class-2"));
    demoSubject.notifyObserver(new Message("Time to Run"));

    demoSubject.removeObserver(demoObserver);
    demoSubject.notifyObserver(new Message("Time to Run"));

  }
}
