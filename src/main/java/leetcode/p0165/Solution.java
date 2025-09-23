package leetcode.p0165;

import java.util.Comparator;

class Solution {

    static class V2 {

        public int compareVersion(String version1, String version2) {
            final int n = version1.length();
            final int m = version2.length();

            int i = 0;
            int j = 0;

            // All the given revisions in version1 and version2 can be stored in a 32-bit integer
            int digit1 = 0;
            int digit2 = 0;

            // Use OR since one tail may remain
            while (i < n || j < m) {
                while (i < n && version1.charAt(i) != '.') {
                    digit1 *= 10;
                    digit1 += version1.charAt(i) - '0';
                    i++;
                }
                i++; // Go forward from the '.' index

                while (j < m && version2.charAt(j) != '.') {
                    digit2 *= 10;
                    digit2 += version2.charAt(j) - '0';
                    j++;
                }
                j++; // Go forward from the '.' index

                if (digit1 < digit2) {
                    return -1;
                }
                if (digit1 > digit2) {
                    return 1;
                }

                digit1 = 0;
                digit2 = 0;
            }

            return 0;
        }

    }

    static class V1 {

        // 1 <= version.length <= 500
        // The maximum length of digit part would be its half + 1
        // + 1 for an exclusive index of an array
        private final static int LIMIT = 500 / 2 + 1 + 1;

        public int compareVersion(String version1, String version2) {
            return new VersionComparator().compare(version1, version2);
        }

        private static class VersionComparator implements Comparator<String> {
            @Override
            public int compare(String v1, String v2) {
                final int[] xs = toFixedLength(v1);
                final int[] ys = toFixedLength(v2);

                for (int i = 0; i < LIMIT; i++) {
                    if (xs[i] < ys[i]) {
                        return -1;
                    }
                    if (xs[i] > ys[i]) {
                        return 1;
                    }
                }
                return 0;
            }

            private static int[] toFixedLength(String version) {
                final String[] cs = version.split("\\.");
                final int n = cs.length;
                // All the given revisions in versions can be stored in a 32-bit integer
                final int[] xs = new int[LIMIT];
                for (int i = 0; i < n; i++) {
                    xs[i] = Integer.parseInt(cs[i]);
                }
                return xs;
            }
        }

    }

}
