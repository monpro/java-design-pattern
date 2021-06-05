package com.monpro.designpattern.solidbasic.alert;

public class Main {

  public static void main(String[] args) {
    ApiStateInfo apiStateInfo = new ApiStateInfo();
    ApplicationContext.getInstance().getAlert().check(apiStateInfo);
  }
}
