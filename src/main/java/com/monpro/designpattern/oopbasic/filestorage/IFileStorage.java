package com.monpro.designpattern.oopbasic.filestorage;

import com.monpro.designpattern.createobject.IdGeneratorProcessSafety;
import com.monpro.designpattern.idgenerator.IdGenerator;

import java.io.File;
import java.util.List;

public interface IFileStorage {

  void saveFile(File file);

  File getFile(String fileId);

  void deleteFile(String fileId);

  void updateFileInfo(String fileId, FileInfo fileInfo);

  List<File> listFiles();

  IdGeneratorProcessSafety load(Class<IdGeneratorProcessSafety> idGeneratorProcessSafetyClass);

  void save(IdGeneratorProcessSafety idGeneratorProcessSafety, Class<IdGeneratorProcessSafety> idGeneratorProcessSafetyClass);
}
