package com.monpro.designpattern.oopbasic.filestorage;

import java.io.File;

public class Main {
  public static void main(String[] args) {

    saveFileIntoCloud(new AwsFileStorage(), new File("./*"));

    // if in future, if we need to use Azure,
    // we could simply switch to AzureFileStorage with least amount of code change
    saveFileIntoCloud(new AzureFileStorage(), new File("./*"));
  }

  private static void saveFileIntoCloud(IFileStorage fileStorage, File file) {
    fileStorage.saveFile(file);
  }
}
