package leetcode.p0658;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // If same distance, smaller number should be preferred.
    // arr is sorted in ascending order.
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        final int n = arr.length;

        // i もしくは i, i+1 前後の, 隣接したものたちを選ぶ.
        // sorted asc なので target と adjacent で consecutive な配列が答えになる.
        final int i = upperBoundBS(arr, x);
        // System.out.println(i);

        final List<Integer> ans = new ArrayList<>();
        if (i == -1) {
            // x is smaller than all of elements.
            for (int l = 0; l < k; l++) {
                ans.add(arr[l]);
            }
            return ans;
        }
        if (i == n) {
            // x is bigger than all of elements.
            for (int r = n - k; r < n; r++) {
                ans.add(arr[r]);
            }
            return ans;
        }
        // 左もしくは右に歪んだ arr=[1,2,3,10,11] k=3, x=3 など
        // 答えが左に偏るケースもある.
        // 結局 `target を挟んだ the leftmost valid window` から右にずらしながら走査, sliding window が無難.
        // それでも O(N).
        // binary search + sliding window = O(log N) + O(N) = O(N)
        int l = i + 1 - k;
        int r = i;
        while (l < 0) {
            l++;
            r++;
        }
        while (r > n - 1) {
            l--;
            r--;
        }
        // System.out.printf("%s, %s %n", l, r);
        while (r < n) {
            // comparison target is x. do not compute a distance between arr[i] instead of x.
            if (r < n - 1 && x - arr[l] > arr[r + 1] - x) {
                l++;
                r++;
            } else {
                break;
            }
        }

        while (l <= r) {
            ans.add(arr[l++]);
        }
        return ans;
    }

    // An index of the biggest value which is smaller or equal to the target value.
    private int upperBoundBS(int[] arr, int target) {
        final int n = arr.length;
        if (target > arr[n - 1]) {
            return n;
        }

        int l = 0;
        // since the center is left-aligned, once the candidate found,
        // we need to move l on m+1. then do -1 to the final l.
        // so r should be exclusive.
        int r = n;

        while (l < r) {
            // left-aligned center. do not fix the left in the middle.
            int m = l + (r - l) / 2;
            if (arr[m] > target) {
                r = m;
            } else {
                // maybe found but try more.
                l = m + 1;
            }
        }
        return l - 1;
    }
}
