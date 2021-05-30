package com.monpro.designpattern.oopbasic.apiauthenticator;

public interface CredentialStorage {
  String getPasswordByAppId(String appId);
}
