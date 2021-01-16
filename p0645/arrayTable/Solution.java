package leetcode.p0645.arrayTable;

class Solution {
  // nums originally contains all the numbers from 1 to n.
  // nums has only one duplicated num and only one missing number.
  // nums may not be sorted.
  public int[] findErrorNums(int[] nums) {
    final int[] res = new int[2];
    final int[] answer = new int[nums.length + 1];

    for (int num : nums) {
      if (answer[num] != 0) {
        res[0] = num;
      }
      answer[num] = num;
    }

    for (int i = 1; i < answer.length; i++) {
      if (answer[i] == 0) {
        res[1] = i;
        break;
      }
    }

    return res;
  }
}
