package com.monpro.designpattern.oopbasic.filestorage;

import java.io.File;
import java.util.List;

public class AzureFileStorage implements IFileStorage {
  @Override
  public void saveFile(File file) {}

  @Override
  public File getFile(String fileId) {
    return null;
  }

  @Override
  public void deleteFile(String fileId) {}

  @Override
  public void updateFileInfo(String fileId, FileInfo fileInfo) {}

  @Override
  public List<File> listFiles() {
    return null;
  }
}
