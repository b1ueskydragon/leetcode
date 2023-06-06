package leetcode.p1502.calc_position;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        final int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        // inappropriate number as a distance
        if ((max - min) % (n - 1) != 0) {
            return false;
        }
        final int distance = (max - min) / (n - 1);
        for (int i = 0; i < n; i++) {
            // the appropriate value when sorted := minValue + distance * position
            if (arr[i] == min + distance * i) {
                continue;
            }
            // inappropriate number as a position
            if ((arr[i] - min) % distance != 0) {
                return false;
            }
            // the appropriate position when sorted := (value - minValue) / distance
            final int pos = (arr[i] - min) / distance;
            // invalid position for the distance
            if (pos >= n || pos < 0) {
                return false;
            }
            // inappropriate duplication
            // the appropriate value already exists on the appropriate position
            if (arr[pos] == arr[i]) {
                return false;
            }
            // swap the value to the appropriate position to check all possible invalid duplicates
            // swap once per loop
            // this may not cost much (swap in the current linear search)
            int tmp = arr[pos];
            arr[pos] = arr[i];
            arr[i] = tmp;
        }
        return true;
    }
}
