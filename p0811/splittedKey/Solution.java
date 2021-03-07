package leetcode.p0811.splittedKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  // Each address will have either 1 or 2 "." characters
  public List<String> subdomainVisits(String[] cpdomains) {
    final List<String> res = new ArrayList<>();
    final Map<String, Map<String, Map<String, Integer>>> countMap = new HashMap<>();

    // build count map
    for (String cpdomain : cpdomains) {
      String[] pair = cpdomain.split(" ");
      int count = Integer.valueOf(pair[0]);
      String[] nodes = pair[1].split("\\.");
      reverse(nodes);

      String top = nodes[0];
      String middle = nodes[1];
      String base = (nodes.length == 3) ? nodes[2] : "";

      countMap.computeIfAbsent(top, key -> new HashMap<>())
          .computeIfAbsent(middle, key -> new HashMap<>());

      int prevBase = countMap.get(top).get(middle).getOrDefault(base, 0);
      countMap.get(top).get(middle).put(base, count + prevBase);
    }

    // aggregate count map
    for (var entryPerTop : countMap.entrySet()) {
      String top = entryPerTop.getKey();
      int topCounter = 0;

      for (var entryPerMiddle : entryPerTop.getValue().entrySet()) {
        String middle = entryPerMiddle.getKey();
        int midCounter = 0;

        for (var entryPerBase : entryPerMiddle.getValue().entrySet()) {
          int baseCounter = entryPerBase.getValue();
          topCounter += baseCounter;
          midCounter += baseCounter;

          String base = entryPerBase.getKey();
          if (base.equals("")) {
            continue;
          }
          res.add(buildString(baseCounter, top, middle, base));
        }
        res.add(buildString(midCounter, top, middle, null));
      }
      res.add(buildString(topCounter, top, null, null));
    }

    return res;
  }

  private static String buildString(int counter,
                                    String top,
                                    String middle,
                                    String base) {

    StringBuilder builder = new StringBuilder();
    builder.append(counter);
    builder.append(" ");

    if (base != null) {
      builder.append(base);
      builder.append(".");
    }

    if (middle != null) {
      builder.append(middle);
      builder.append(".");
    }
    builder.append(top);
    return builder.toString();
  }

  private static void reverse(String[] ary) {
    int i = 0;
    int j = ary.length - 1;
    while (i < j) {
      String tmp = ary[i];
      ary[i] = ary[j];
      ary[j] = tmp;
      i++;
      j--;
    }
  }
}
