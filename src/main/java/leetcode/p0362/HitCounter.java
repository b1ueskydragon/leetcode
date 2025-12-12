package leetcode.p0362;


import java.util.Deque;
import java.util.LinkedList;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * <p>
 * Follow-up: What if our system has limited memory?
 */
class HitCounter {

  private static final int MAX_LIMIT_SEC = 300;

  private final Deque<Integer> hits = new LinkedList<>();

  public void hit(int timestamp) {
    hits.addFirst(timestamp);
  }

  /**
   * @param upper unit is second
   * @return total hits
   */
  public int getHits(int upper) {
    int lower = upper - MAX_LIMIT_SEC;

    while (!hits.isEmpty()) {
      int hit = hits.peekLast();
      if (hit > lower) break;
      hits.pollLast();
    }

    return hits.size();
  }
}
