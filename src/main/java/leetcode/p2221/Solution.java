package leetcode.p2221;

class Solution {

    static class V2 {

        public int triangularSum(int[] nums) {

            // e.g.,
            // [1, 2, 3, 4, 5]
            // [1+2, 2+3, 3+4, 4+5] (%10 foreach)
            // [1+2+2+3, 2+3+3+4, 3+4+4+5] (%10 foreach)
            // [1+2+2+3+2+3+3+4, 2+3+3+4+3+4+4+5] (%10 foreach)
            // [1+2+2+3+2+3+3+4+2+3+3+4+3+4+4+5]
            // 1 *1 + 2 *4 + 3 *6 + 4 *4 + 5 *1 ...
            // (1,4,6,4,1) ... Pascal's triangle
            // (4C0 + 4C1 + 4C2 + 4C3 + 4C4)
            // nCk = n! / k!(n-k)!

            final int n = nums.length;
            int sum = nums[0]; // == nums[0] * 1

            // e.g.,
            // 4C0 + 4C1 + 4C2 + 4C3 + 4C4
            // = 1 + 4/1 + (4*3)/(2*1) + (4*3*2)/(3*2*1) + (4*3*2*1)/(4*3*2*1)
            for (int i = 1; i < n; i++) {
                // %10 済み
                final int nCi = crt(lucasP5(n - 1, i), lucasP2(n - 1, i));
                sum = (sum + nums[i] % 10 * nCi) % 10;
            }
            return sum % 10;
        }

        /// /// 分解 //////

        // nCi % 5
        //
        // C(n, i) = ∏ ( C(n_j, k_j) % p)
        // p is a prime number,
        // j = p進数表示した際の桁番号
        // e.g.,
        // 12C7, p=5, 12C7 % 5 を求めたい:
        // 12 = 2 * (5^0) + 2 * (5^1) -> n_j = [0, 1]
        // 7 = 2 * (5^0) + 1 * (5^1) -> k_j = [0, 1]
        // C(2, 2) % 5 * C(2, 1) % 5 = C(12, 7) % 5
        private static int lucasP5(int n, int i) {
            // 1000 = 13000(5), 5桁
            final int[] N = new int[5];
            int j = 0;
            while (n > 0) {
                N[j++] = n % 5;
                n /= 5;
            }

            final int[] I = new int[5];
            j = 0;
            while (i > 0) {
                I[j++] = i % 5;
                i /= 5;
            }

            int acc = 1;
            for (j = 0; j < 5; j++) {
                acc *= combination(N[j], I[j]) % 5;
            }
            return acc;
        }

        // nCi % 2
        private static int lucasP2(int n, int i) {
            // 1000 < (1 << 10), 10桁
            final int[] N = new int[10];
            int j = 0;
            while (n > 0) {
                N[j++] = (n & 1);
                n >>= 1;
            }

            final int[] I = new int[10];
            j = 0;
            while (i > 0) {
                I[j++] = (i & 1);
                i >>= 1;
            }

            int acc = 1;
            for (j = 0; j < 10; j++) {
                acc *= combination(N[j], I[j]) % 2;
            }
            return acc;
        }

        // C(n,i)
        // For small integers
        private static int combination(int n, int i) {
            if (n < i) {
                // early return (works anyway without it)
                return 0;
            }
            int u = 1; // 分子
            int d = 1; // 分母
            for (int j = 0; j < i; j++) {
                u = u * (n - j);
                d = d * (j + 1);
            }
            return u / d;
        }


        /// /// 合成 //////

        // x % 10 (x は予め求めた nCi 相当)
        //
        // x はわからないが
        // x%5, x%2 はわかる場合
        // x%10 の結果がわかる
        // e.g.,
        // x%5=4 になる x候補: 4, 9, 14, 19, ...
        // x%2=0 になる x候補: 0, 2, 4, 6, 8, 10, 12, 14, 16, ...
        // -> どちらにも属する x候補=4, 14, ...
        // -> 何であろう x%10=4
        private static int crt(int c5, int c2) {
            // c5 は予め求めた `x%5` 相当の結果, c2 は `x%2` 相当の結果
            // c5 候補の中で偶数 or 奇数である任意の一つを探すで OK
            // (x%2=1 なら奇数, x%2=0 なら偶数なので)
            // Note: c5 & 1 == 0 のうちは偶数
            if ((c5 & 1) != c2) {
                c5 += 5;
            }
            return c5 % 10;
        }

    }

    static class V1 {

        public int triangularSum(int[] nums) {
            int sum = 0;
            for (int num : rec(nums)) {
                sum += num;
            }
            return sum;
        }

        private int[] rec(int[] nums) {
            if (nums.length == 1) {
                return nums;
            }
            final int n = nums.length;
            final int[] newNums = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                newNums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            return rec(newNums);
        }

    }

}
