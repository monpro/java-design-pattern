package com.monpro.designpattern.behavior.strategysorter;

import java.util.HashMap;
import java.util.Map;

public class SorterFactory {
  private static final Map<String, ISorter> sorterMap= new HashMap<>();
  public static final String QUICK_SORT= "QuickSort";
  public static final String EXTERNAL_SORT= "ExternalSort";
  public static final String CONCURRENT_EXTERNAL_SORT= "ConcurrentExternalSort";
  public static final String MAP_REDUCE_SORT= "MapReduceSort";

  static {
    sorterMap.put("QuickSort", new QuickSort());
    sorterMap.put("ExternalSort", new ExternalSort());
    sorterMap.put("ConcurrentExternalSort", new ConcurrentExternalSort());
    sorterMap.put("MapReduceSort", new MapReduceSort());
  }

  public static ISorter getSorter(final String sorterType) {
    return sorterMap.get(sorterType);
  }
}
