package com.monpro.designpattern.behavior.strategysorter;

import java.io.File;

import static com.monpro.designpattern.behavior.strategysorter.SorterFactory.*;

public class Sorter {

  private static final long GB = 1000 * 1000 * 1000;

  public void sortFile(final String filePath) {
    final File file = new File(filePath);
    final long fileSize = file.length();
    ISorter sorter;
    if (fileSize < 6 * GB) {
      sorter = SorterFactory.getSorter(QUICK_SORT);
    } else if (fileSize < 10 * GB) {
      sorter = SorterFactory.getSorter(EXTERNAL_SORT);
    } else if (fileSize < 100 * GB) {
      sorter = SorterFactory.getSorter(CONCURRENT_EXTERNAL_SORT);
    } else {
      sorter = SorterFactory.getSorter(MAP_REDUCE_SORT);
    }
    sorter.sort(file);
  }
}
