package com.monpro.designpattern.behavior.strategysorter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.monpro.designpattern.behavior.strategysorter.SorterFactory.*;

public class Sorter {

  private static final long GB = 1000 * 1000 * 1000;
  private static final List<SorterRange> range = new ArrayList<>();

  static {
    range.add(new SorterRange(0, 6 * GB, SorterFactory.getSorter(QUICK_SORT)));
    range.add(new SorterRange(6 * GB, 10 * GB, SorterFactory.getSorter(EXTERNAL_SORT)));
    range.add(new SorterRange(10 * GB, 100 * GB, SorterFactory.getSorter(CONCURRENT_EXTERNAL_SORT)));
    range.add(new SorterRange(100 * GB, Long.MAX_VALUE, SorterFactory.getSorter(MAP_REDUCE_SORT)));
  }


  public void sortFile(final String filePath) {
    final File file = new File(filePath);
    final long fileSize = file.length();
    ISorter sorter = null;
    for(final SorterRange sorterRange : range) {
      if(sorterRange.inRange(fileSize)) {
        sorter = sorterRange.getSorter();
        break;
      }
    }
    sorter.sort(file);
  }

  private static class SorterRange {
    private long start;
    private long end;
    private ISorter sorter;

    public SorterRange(final long start, final long end, final ISorter sorter) {
      this.start = start;
      this.end = end;
      this.sorter = sorter;
    }

    public ISorter getSorter() {
      return sorter;
    }

    public boolean inRange(final long size) {
      return size >= start && size <= end;
    }
  }
}
