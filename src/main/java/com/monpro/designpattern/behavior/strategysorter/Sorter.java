package com.monpro.designpattern.behavior.strategysorter;

import java.io.File;

public class Sorter {

  private static final long GB = 1000 * 1000 * 1000;

  public void sortFile(final String filePath) {
    final File file = new File(filePath);
    final long fileSize = file.length();
    if (fileSize < 6 * GB) {
      quickSort(file);
    } else if (fileSize < 10 * GB) {
      externalSort(file);
    } else if  (fileSize < 100 * GB) {
      concurrentExternalSort(file);
    } else {
      mapReduce(file);
    }
  }

  private void mapReduce(final File file) {
  }

  private void concurrentExternalSort(final File file) {
  }

  private void externalSort(final File file) {
  }

  private void quickSort(final File file) {
  }
}
