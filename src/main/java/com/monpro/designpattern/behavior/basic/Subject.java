package com.monpro.designpattern.behavior.basic;

public interface Subject {
  void registerObserver(final Observer observer);
  void removeObserver(final Observer observer);
  void notifyObserver(final Message message);
}
