package leetcode.p0118.s2025;

import java.util.ArrayList;
import java.util.List;

class Solution {
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
