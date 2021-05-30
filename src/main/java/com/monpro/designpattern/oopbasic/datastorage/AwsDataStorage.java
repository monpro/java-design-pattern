package com.monpro.designpattern.oopbasic.datastorage;

import java.io.File;
import java.util.UUID;

/** AzureDataStorage need token when uploading and downloading */
public class AwsDataStorage implements DataStorage {

  @Override
  public String upload(File file, String bucketName) {
    String token = generateToken();
    return null;
  }

  @Override
  public File download(String url) {
    String token = generateToken();
    return null;
  }

  private String generateToken() {
    return UUID.randomUUID().toString();
  }
}
