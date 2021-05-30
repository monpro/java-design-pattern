package com.monpro.designpattern.oopbasic.datastorage;

import java.io.File;

/** AzureDataStorage doesn't need token when uploading and downloading */
public class AzureDataStorage implements DataStorage {

  @Override
  public String upload(File file, String bucketName) {
    return null;
  }

  @Override
  public File download(String url) {
    return null;
  }
}
