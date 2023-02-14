package leetcode.p0067.s2021.integer;

class Solution {
  public String addBinary(String a, String b) {
    int tmpNum = Integer.valueOf(a) + Integer.valueOf(b);
    return String.valueOf(calcAsBinary(tmpNum));
  }

  private int calcAsBinary(int num) {
    int level = 0;
    int tmp = num;
    while (tmp > 0) {
      tmp /= 10;
      level++;
    }

    int i = 1;
    while (i <= level) {
      int base = num % (int) Math.pow(10, i);
      int baseHead = base / (int) Math.pow(10, i - 1);
      int baseTail = base % (int) Math.pow(10, i - 1);

      if (baseHead > 1) { // baseHead is 2 or 3. for example, 10 + 11
        num -= base;
        int newBase = (int) Math.pow(10, i) + baseTail;
        if (baseHead > 2) { // baseHead is 3. for example, 111 + 111
          newBase += (int) Math.pow(10, i - 1);
        }
        num += newBase;
      }

      i++;
    }
    return num;
  }
}
