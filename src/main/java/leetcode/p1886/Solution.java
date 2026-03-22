package leetcode.p1886;

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        // (0, 0) ~ (n-1, n-1)
        // (1, 1) ~ (n-2, n-2)
        //  ...
        int n = mat.length;
        int start = 0;
        int end = n - 1;
        boolean[] prevValid = null;
        while (start < end) {
            // 全体 (n-1)*4 bits,
            // max 36 bits,
            // (1 << 36) < Long.MAX_VALUE
            long outer1 = 0;
            long outer2 = 0;
            // e.g,
            //        →
            //   0 0 0 ↓
            //   0   0
            // ↑ 1 1 1
            //   ←
            // Serialize to 0 0 | 0 0 | 1 1 | 1 0
            for (int i = start; i < end; i++) {
                outer1 = (outer1 << 1) + mat[start][i];
                outer2 = (outer2 << 1) + target[start][i];
            }
            for (int i = start; i < end; i++) {
                outer1 = (outer1 << 1) + mat[i][end];
                outer2 = (outer2 << 1) + target[i][end];
            }
            for (int i = end; i > start; i--) {
                outer1 = (outer1 << 1) + mat[end][i];
                outer2 = (outer2 << 1) + target[end][i];
            }
            for (int i = end; i > start; i--) {
                outer1 = (outer1 << 1) + mat[i][start];
                outer2 = (outer2 << 1) + target[i][start];
            }

            int attempt = 4;
            boolean[] isValid = new boolean[attempt + 1];
            while (attempt > 0) {
                // e.g.,
                // if n=3, 全体 (n-1)*4 = 8 bits, 下2 bits ずつ rotate.
                final int bits = (n - 1) * 4;
                int i = 0;
                // 下 (n-1) bits
                long lsb = 0;
                while (i < n - 1) {
                    lsb = ((outer1 & 1) << i) + lsb;
                    outer1 >>>= 1;
                    i++;
                }
                // 下 (n-1) bits 分を除く桁数を left shift して新しい head に.
                final long head = lsb << (bits - i);
                // Rotated.
                outer1 = head + outer1;
                attempt--;
                if (outer1 == outer2) {
                    isValid[4 - attempt] = true;
                }
            }

            boolean atLeastOnePathExists = false;
            if (prevValid == null) {
                for (boolean exists : isValid) {
                    if (exists) {
                        atLeastOnePathExists = true;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < isValid.length; i++) {
                    if (isValid[i] && isValid[i] == prevValid[i]) {
                        atLeastOnePathExists = true;
                        break;
                    }
                }
            }
            if (!atLeastOnePathExists) {
                return false;
            }

            prevValid = isValid.clone();
            start++;
            end--;
            n = end - start + 1;
        }

        if (start == end) {
            return mat[start][end] == target[start][end];
        }
        return true;
    }
}
