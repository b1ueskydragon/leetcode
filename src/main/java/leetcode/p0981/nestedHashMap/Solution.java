package leetcode.p0981.nestedHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
class TimeMap {

  private final Map<String, Map<Integer, String>> timeMap;

  /**
   * Initialize your data structure here.
   */
  public TimeMap() {
    timeMap = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (timeMap.containsKey(key)) {
      final Map<Integer, String> record = timeMap.get(key);
      record.put(timestamp, value);
      return;
    }
    final Map<Integer, String> newRecord = new HashMap<>();
    newRecord.put(timestamp, value);
    timeMap.put(key, newRecord);
  }

  public String get(String key, int timestamp) {
    if (!timeMap.containsKey(key)) {
      return "";
    }

    final Map<Integer, String> requestedRecord = timeMap.get(key);

    // The timestamps for all TimeMap.set operations are strictly increasing.
    if (!requestedRecord.containsKey(timestamp)) {
      for (int t = timestamp - 1; t > 0; t--) { // O(N), n is the number of timestamp.
        if (!requestedRecord.containsKey(t)) {
          continue;
        }
        final String res = requestedRecord.get(t);
        requestedRecord.put(timestamp, res); // reusing previous result may help next retrieval can make early stop.
        return res;
      }
      return "";
    }
    return requestedRecord.get(timestamp);
  }
}
