package leetcode.p3838;

class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        final var sb = new StringBuilder();
        for (String word : words) {
            int acc = 0;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                acc = (acc + weights[i] % 26) % 26;
            }
            // reverse order
            sb.append((char) ('z' - acc));
        }
        return sb.toString();
    }
}
