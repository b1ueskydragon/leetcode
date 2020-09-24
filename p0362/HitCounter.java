package leetcode.p0362;


import java.util.ArrayList;
import java.util.List;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 */
public class HitCounter {

  private static final int MAX_LIMIT_SEC = 300;

  private final List<Integer> hits = new ArrayList<>();

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

    for (int hit : hits) {
      if (lower < hit && hit <= upper) total += 1;
    }

    return total;
  }

  public static void main(String[] args) {
    HitCounter counter = new HitCounter();

    counter.hit(1);
    counter.hit(2);
    counter.hit(3);

    System.out.println(counter.getHits(4) == 3);

    counter.hit(300);

    System.out.println(counter.getHits(300) == 4);

    System.out.println(counter.getHits(301) == 3);
  }

}
