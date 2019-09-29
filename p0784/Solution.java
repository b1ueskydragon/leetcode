package leetcode.p0784;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  private static <T> List<List<T>> product2(List<T> xs, List<T> ys) {
    return new ArrayList<>() {{
      xs.forEach(x -> ys.forEach(y -> add(Arrays.asList(x, y))));
    }};
  }

//  private <T> List<List<T>> product(List<List<T>> lists) {
//
//  }
//
//  public List<String> letterCasePermutation(String S) {
//
//  }

  public static void main(String[] args) {
    product2(List.of('a', 'A'), List.of('b', 'B'))
        .forEach(list -> System.out.printf("%s ", list));
  }
}