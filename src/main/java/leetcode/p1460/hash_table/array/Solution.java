package leetcode.p1460.hash_table.array;

class Solution {
  // Most sorting methods are based on the exchange of two elements or the exchange of an element itself.
  // In other words, if the elements are the same between the two arrays,
  // it can be sorted to any order regardless of first order.
  // Constraints:
  // target.length == arr.length
  // max elements are 1000
  public boolean canBeEqual(int[] target, int[] arr) {
    final int[] table = new int[1001];
    for (int i = 0; i < target.length; i++) {
      table[target[i]]++;
      table[arr[i]]--;
    }
    for (int stock : table) {
      if (stock != 0) return false;
    }
    return true;
  }
}
