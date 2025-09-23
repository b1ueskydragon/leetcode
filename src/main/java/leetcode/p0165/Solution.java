package leetcode.p0165;

import java.util.Comparator;

class Solution {

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
