package leetcode.p0006;

class Solution {

    static class V2 {

        public String convert(String s, int numRows) {
            if (numRows < 2) {
                // Edge case
                return s;
            }
            final int offset = numRows - 2;
            final int size = s.length();
            // The length of one pair of down and up
            final int chunkSize = numRows + offset;

            // We will build: ↘︎↗︎↘︎↗︎↘︎↗︎...,
            // e.g.,
            // P        I         N
            //  A     L   S     I   G
            //   Y  A      H   R
            //    P          I

            final StringBuilder[] rows = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                // Put the instance first
                rows[i] = new StringBuilder();
            }

            for (int i = 0; i < size; i++) {
                if (i % chunkSize < numRows) {
                    // build ↘︎
                    rows[i % chunkSize].append(s.charAt(i));
                } else {
                    // build ↗︎
                    rows[chunkSize - i % chunkSize].append(s.charAt(i));
                }
            }

            final var res = new StringBuilder();
            for (var row : rows) {
                res.append(row);
            }

            return res.toString();
        }

    }

    static class V1 {

        public String convert(String s, int numRows) {
            if (numRows < 2) {
                // Edge case
                return s;
            }
            final int offset = numRows - 2;
            final int size = s.length();
            final int chunkSize = numRows + offset;
            // Since we will build: ↘︎↗︎↘︎↗︎↘︎↗︎...,
            // And any character won't be lost,
            // Column size is equivalent to the entire string length
            // e.g.,
            // s=PAYPALISHIRING, numRows=4,
            // P        I         N
            //  A     L   S     I   G
            //   Y  A      H   R
            //    P          I
            final char[][] matrix = new char[numRows][size];
            int i = 0;
            // `j` will constantly move the → direction
            for (int j = 0; j < size; j++) {
                if (i % chunkSize < numRows) {
                    // build ↘︎
                    matrix[i % chunkSize][j] = s.charAt(i);
                } else {
                    // build ↗︎
                    matrix[chunkSize - i % chunkSize][j] = s.charAt(i);
                }
                i++;
            }

            final var sb = new StringBuilder();
            for (char[] xs : matrix) {
                for (char x : xs) {
                    if (x != 0) {
                        sb.append(x);
                    }
                }
            }

            return sb.toString();
        }

    }
}
