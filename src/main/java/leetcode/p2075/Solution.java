package leetcode.p2075;

class Solution {
    // (0, 0) -> (1, 1) -> (2, 2) -> .. + (0, 1) -> (1, 2) -> (2, 3) -> ..
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.isEmpty()) {
            return "";
        }
        // Constraints: EncodedText is a valid encoding of some originalText that does not have trailing spaces.
        final int n = encodedText.length() / rows; // the number of columns

        final char[][] mat = new char[rows][n];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = encodedText.charAt(j + (n * i));
            }
        }

        final var ans = new StringBuilder();
        for (int k = 0; k < n; k++) {
            int i = 0;
            int j = k;
            while (i < rows && j < n) {
                ans.append(mat[i][j]);
                i++;
                j++;
            }
        }

        int r = ans.length() - 1;
        while (ans.charAt(r) == ' ') {
            ans.deleteCharAt(r);
            r--;
        }

        return ans.toString();
    }
}
