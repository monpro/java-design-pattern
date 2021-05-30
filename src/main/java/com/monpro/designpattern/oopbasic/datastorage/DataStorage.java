package com.monpro.designpattern.oopbasic.datastorage;

    import java.io.File;

public interface DataStorage {
  String upload(File file, String bucketName);

  File download(String url);
}
