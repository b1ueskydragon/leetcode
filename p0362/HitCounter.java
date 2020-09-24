package leetcode.p0362;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 */
public class HitCounter {

  private static final int MAX_LIMIT_SEC = 300;

  // it would save memory space, but timestamps will be removed.
  private final Queue<Integer> hits = new LinkedList<>();

  public void hit(int timestamp) {
    hits.add(timestamp);
  }

  /**
   * @param upper unit is second
   * @return total hits
   */
  public int getHits(int upper) {
    int total = 0;
    int lower = upper - MAX_LIMIT_SEC;

    while (!hits.isEmpty()) {
      if (hits.poll() > lower) total++;
    }

    return total;
  }
}
