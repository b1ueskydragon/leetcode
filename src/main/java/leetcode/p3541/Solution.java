package leetcode.p3541;

class Solution {
    // Cover 'a' to 'z'
    private static final boolean[] isVowel = new boolean[26];

    static {
        isVowel['a' - 'a'] = true;
        isVowel['e' - 'a'] = true;
        isVowel['i' - 'a'] = true;
        isVowel['o' - 'a'] = true;
        isVowel['u' - 'a'] = true;
    }

    public int maxFreqSum(String s) {
        // Cover 'a' to 'z'
        final int[] freq = new int[26];

        int maxFreqV = 0;
        int maxFreqC = 0;
        for (char c : s.toCharArray()) {
            // char to int
            final int i = c - 'a';
            freq[i]++;
            // Same `i` will appear multiple time, so it's OK to count in here
            if (isVowel[i]) {
                maxFreqV = Math.max(maxFreqV, freq[i]);
            } else {
                maxFreqC = Math.max(maxFreqC, freq[i]);
            }
        }

        return maxFreqV + maxFreqC;
    }
}
