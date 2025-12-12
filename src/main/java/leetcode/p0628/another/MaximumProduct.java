package leetcode.p0628.another;

/**
 * just find a maximum product.
 */
class MaximumProduct {
  public int maximumProduct(int[] nums) {
    // both caches should keep the biggest absolute value
    int[] posCache = new int[nums.length + 1];
    int[] negCache = new int[nums.length + 1];
    posCache[0] = 1;
    negCache[0] = 1;

    int i = 1;
    for (int num : nums) {
      if (num >= 0) {
        // go to the posCache.
        // care multiple zero
        posCache[i] = Math.max(posCache[i - 1] * num, posCache[i - 1]);
        // just copy the prev value
        negCache[i] = negCache[i - 1];
      } else {
        // go to the negCache
        negCache[i] = Math.min(posCache[i - 1] * num, negCache[i - 1]);
        // go to the posCache
        posCache[i] = Math.max(negCache[i - 1] * num, posCache[i - 1]);
      }
      i++;
    }

    int max = 0;
    for (int pos : posCache) {
      max = Math.max(max, pos);
    }

    return max;
  }
}
