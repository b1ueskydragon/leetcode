package leetcode.p3411;

class Solution {
    // prod(arr) == lcm(arr) * gcd(arr)
    // 1 <= nums[i] <= 10
    // 2 <= nums.length <= 100
    public int maxLength(int[] nums) {

        // subarray = [a, b, c]
        // (a, b), (b, c), (a, c) が全て互いに素の場合, gcd(a, b, c) = 1
        //
        // ただし,
        // gcd(a, b, c) = 1 のとき (a, b), (b, c), (a, c) が全て互いに素は保証されない.

        // (1) gcd(a * b, c) > 1 のとき, (a or b) and c を割り切る素因数 p が必ず存在する.
        // (2) subarray から任意の2要素をどれでも選んだとき, その2つが互いに素の場合,
        //     gcd(subarray) = 1, lcm(subarray) = product のため, gcd * lcm = product.
        //     つまり gcd = 1 は十分条件ではないが gcd * lcm = product における必要条件.

        // (2) は (1) の否定.
        // A: a と c が素因数を共有する
        // B: b と c が素因数を共有する
        // (1): A || B
        // (2): !(A || B) == !A && !B

        final int n = nums.length;
        int l = 0;
        int r = 0;
        int prd = 1;
        // len(subarray) == 2 の時は互いに素でなくても gcd * lcm = product.
        // それ超過の長さでは成立しないので (1), (2) が必要だった.
        int maxLen = 2;
        while (r < n) {
            // 試しで左を削ってみて gcd == 1 になれば
            // subarray の任意の2要素同士は全て互いに素 (window で保ちたい状態) になる
            while (gcd(prd, nums[r]) > 1) {
                prd /= nums[l++];
            }
            prd *= nums[r];
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    // e.g.,
    // gcd(9,6) == gcd(3, 6) == gcd(3, 0) = 3
    private int gcd(int a, int b) {
        if (b > a) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        if (b == 1) {
            return 1;
        }
        return gcd(a % b, b);
    }
}
