package leetcode.p0811.concatedKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
  public List<String> subdomainVisits(String[] cpdomains) {
    final Map<String, Integer> countMap = new HashMap<>();

    // aggregate
    for (String cpdomain : cpdomains) {
      final String[] pair = cpdomain.split(" ");
      final int count = Integer.valueOf(pair[0]);
      final String[] keys = pair[1].split("\\.");

      String prevKey = "";
      for (int i = keys.length - 1; i >= 0; i--) {
        final String currKey = keys[i];
        final String key = buildKey(prevKey, currKey);
        countMap.put(key, count + countMap.getOrDefault(key, 0));
        prevKey = key;
      }
    }

    return countMap.entrySet()
        .stream()
        .map(entry -> entry.getValue() + " " + entry.getKey())
        .collect(Collectors.toUnmodifiableList());
  }

  private static String buildKey(String prevKey,
                                 String currKey) {
    final StringBuilder builder = new StringBuilder();
    builder.append(currKey);
    if (!prevKey.equals("")) {
      builder.append(".");
      builder.append(prevKey);
    }
    return builder.toString();
  }
}
