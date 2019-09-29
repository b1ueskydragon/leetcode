package leetcode.p0784;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private static <T> List<List<T>> product2(List<T> xs, List<T> ys) {
    List<List<T>> product = new ArrayList<>();
    for (T x : xs) {
      for (T y : ys) {
        List<T> chunk = new ArrayList<>() {{ add(x); }};
        chunk.add(y);
        product.add(chunk);
      }
    }
    return product;
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
        .forEach(list -> {
          System.out.print("(");
          list.forEach(t -> System.out.printf(" %s ", t));
          System.out.print(")");
        });
  }
}