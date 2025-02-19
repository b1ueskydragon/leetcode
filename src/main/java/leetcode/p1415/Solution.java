package leetcode.p1415;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 22 ms (29.84%)
 * Memory: 45.86 MB (9.11%)
 */
class Solution {
    // Get k-th Lexicographical String of All Happy Strings of Length n
    // String is 1-indexed
    // 1 <= n <= 10
    // 1 <= k <= 100
    public String getHappyString(int n, int k) {
        // e.g. n=3, a size of the result is 3 * 2 * 2
        if (k > 3 * (1 << (n - 1))) {
            return "";
        }
        final List<String> res = new ArrayList<>();
        buildHappyString(n, "", "abc", res);
        return res.get(k - 1);
    }

    private void buildHappyString(int n, String acc, String letter, List<String> res) {
        if (n == 0) {
            res.add(acc);
            return;
        }
        for (char head : letter.toCharArray()) {
            // To keep lexicographical order
            // NG: head + second
            // OK: second + head
            buildHappyString(n - 1, acc + head, remainingLetter(head), res);
        }
//        // For-loop version of the recursion (just an initial idea, case n=3)
//        for (char first : letter.toCharArray()) {
//            for (char second : remainingLetter(first).toCharArray()) {
//                for (char third : remainingLetter(second).toCharArray()) {
//                    System.out.println("" + first + second + third);
//                }
//            }
//        }
    }

    private String remainingLetter(char firstPick) {
        return switch (firstPick) {
            case 'a' -> "bc";
            case 'b' -> "ac";
            case 'c' -> "ab";
            default -> ""; // exception
        };
    }
}
