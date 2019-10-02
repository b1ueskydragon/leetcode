package leetcode.p0784;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * coding style jdk 8
 */
public class Solution {

  private static <T> List<List<T>> product2(List<T> xs, List<T> ys) {
    return xs.stream().flatMap(x -> ys.stream().map(y -> Arrays.asList(x, y)))
        .collect(Collectors.toList());
  }

//  private static <T> List<List<T>> product(List<List<T>> lists) {
//    if (lists.isEmpty()) return Collections.emptyList();
//    else if (lists.size() == 1) return Collections.unmodifiableList(lists);
//    else if (lists.size() == 2) return product2(lists.get(0), lists.get(1));
//    else
//  }

//  public List<String> letterCasePermutation(String S) {
//
//  }

  /**
   * coding style jdk 11 for test
   */
  public static void main(String[] args) {
    product2(List.of('a', 'A'), List.of('b', 'B'))
        .forEach(list -> System.out.printf("%s ", list));

//    System.out.print(System.getProperty("line.separator"));
//
//    product(List.of(List.of('a', 'A'), List.of('b', 'B')))
//        .forEach(list -> System.out.printf("%s ", list));
  }
}
