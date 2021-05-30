package com.monpro.designpattern.oopbasic.filestorage;

import java.io.File;
import java.util.List;

public interface IFileStorage {

  void saveFile(File file);

  File getFile(String fileId);

  void deleteFile(String fileId);

  void updateFileInfo(String fileId, FileInfo fileInfo);

  List<File> listFiles();
}
