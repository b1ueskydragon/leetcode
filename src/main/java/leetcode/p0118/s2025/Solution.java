package leetcode.p0118.s2025;

import java.util.ArrayList;
import java.util.List;

class Solution {

    static class V1 {

        public List<List<Integer>> generate(int numRows) {
            final List<List<Integer>> resAll = new ArrayList<>();
            List<Integer> prevRes = new ArrayList<>();
            for (int i = 1; i <= numRows; i++) {
                List<Integer> res = gen(prevRes);
                resAll.add(res);
                prevRes = res;
            }
            return resAll;
        }

        private List<Integer> gen(List<Integer> prevRes) {
            final int n = prevRes.size() + 1; // equivalent to to-be res#size
            final List<Integer> res = new ArrayList<>();
            res.add(1);
            if (n == 1) {
                return res;
            }
            for (int i = 1; i < n - 1; i++) {
                res.add(prevRes.get(i - 1) + prevRes.get(i));
            }
            res.add(1);
            return res;
        }

    }

    static class V2 {

        public List<List<Integer>> generate(int numRows) {
            // Base case
            if (numRows == 1) {
                // Should be mutable
                List<List<Integer>> base = new ArrayList<>();
                List<Integer> row = new ArrayList<>();
                row.add(1);
                base.add(row);
                return base;
            }
            // Recursive case
            List<List<Integer>> generated = generate(numRows - 1);
            List<Integer> prev = generated.get(numRows - 2); // Get the last row
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int i = 1; i < numRows - 1; i++) {
                curr.add(prev.get(i - 1) + prev.get(i));
            }
            curr.add(1);
            generated.add(curr);
            return generated;
        }

    }

}
