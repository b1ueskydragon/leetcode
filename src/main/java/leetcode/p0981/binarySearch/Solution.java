package leetcode.p0981.binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {

  private final Map<String, List<Pair<Integer, String>>> timeMap;

  /**
   * Initialize your data structure here.
   */
  public TimeMap() {
    timeMap = new HashMap<>();
  }

  // The timestamps for all TimeMap.set operations are strictly increasing,
  // Hence the List of Pairs will be sorted by timestamps. -> BinarySearch.
  public void set(String key, String value, int timestamp) {
    timeMap.putIfAbsent(key, new ArrayList<>());
    timeMap.get(key).add(new Pair<>(timestamp, value));
  }

  public String get(String key, int timestamp) {
    if (!timeMap.containsKey(key)) {
      return "";
    }

    final List<Pair<Integer, String>> assigned = timeMap.get(key);

    int l = 0;
    int r = assigned.size() - 1;

    while (l < r - 1) { // Both l and r might be m, hence the range which could be a break condition (r-l) should be 1.
      int m = l + (r - l) / 2;
      int midTimeStamp = assigned.get(m).getTime();
      if (midTimeStamp == timestamp) {
        return assigned.get(m).getValue();
      }
      if (midTimeStamp < timestamp) {
        l = m;
      } else {
        r = m;
      }
    }

    // Already narrowed and just find which is closer to timestamp, point l or r.
    if (assigned.get(r).getTime() <= timestamp) {
      return assigned.get(r).getValue();
    }
    if (assigned.get(l).getTime() <= timestamp) {
      return assigned.get(l).getValue();
    }

    return "";
  }
}

class Pair<T, V> {
  private T t;
  private V v;

  Pair(T t, V v) {
    this.t = t;
    this.v = v;
  }

  T getTime() {
    return this.t;
  }

  V getValue() {
    return this.v;
  }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
