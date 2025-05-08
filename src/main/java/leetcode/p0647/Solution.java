package leetcode.p0647;

class Solution {
    public int countSubstrings(String s) {
        final int n = s.length();
        // s="abccba"
        //  ij
        // "cc" -> palindrome
        //  i  j
        // "bccb" -> palindrome. We don't need to check whether "cc" is palindrome or not again
        //  i    j
        // "abccba" -> palindrome. We don't need to check whether "bccb" is palindrome or not again
        // DP. Check whether s[i...j] is palindrom or not
        final boolean[][] isPalindrome = new boolean[n][n];
        int count = 0;

        // The right(j) need to move faster than the left(i)
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    // Cannot build palindrome
                    continue;
                }
                if (j - i < 2 || isPalindrome[i + 1][j - 1]) {
                    // When s[i] == s[j]
                    // j - i < 2 will cover conditions below which `isPalindrome` cannot cover
                    // 1. Single-character substrings (i == j) e.g., "a", i=0, j=0
                    // 2. Two-character substrings (j == i + 1) e.g., "aa", i=0, j=1
                    isPalindrome[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
