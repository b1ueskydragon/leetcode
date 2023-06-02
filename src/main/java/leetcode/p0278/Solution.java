package leetcode.p0278;

/**
 * The isBadVersion API is defined in the parent class VersionControl.
 * boolean isBadVersion(int version);
 * <p>
 * All the versions after a bad version are also bad.
 */
class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int l = 1;
    int r = n;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (!isBadVersion(mid)) l = mid + 1;
      else r = mid; // keep it in place. should check if is the first or not.
    }
    return l;
  }
}

/**
 * A mock class and mock return to pass the compilation.
 */
class VersionControl {
  boolean isBadVersion(int version) {
    return true;
  }
}
