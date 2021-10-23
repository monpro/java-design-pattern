package com.monpro.designpattern.behavior.strategysorter;

import java.io.File;

public class Sorter {

  private static final long GB = 1000 * 1000 * 1000;

  public void sortFile(final String filePath) {
    final File file = new File(filePath);
    final long fileSize = file.length();
    ISorter sorter;
    if (fileSize < 6 * GB) {
      sorter = new QuickSort();
    } else if (fileSize < 10 * GB) {
      sorter = new ExternalSort();
    } else if (fileSize < 100 * GB) {
      sorter = new ConcurrentExternalSort();
    } else {
      sorter = new MapReduceSort();
    }
    sorter.sort(file);
  }
}
