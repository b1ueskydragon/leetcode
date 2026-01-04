package leetcode.p1390;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private static final int LIMIT = 100_000;

    // 1,2,4,8 など prime^3 型以外は (prime x prime), (1 x self) の組み合わせのみ.
    public int sumFourDivisors(int[] nums) {
        // false is prime
        final boolean[] isNotPrime = new boolean[LIMIT + 1];
        for (int i = 2; i * i <= LIMIT; i++) {
            // 素数倍のみ check で OK.
            if (isNotPrime[i]) {
                continue;
            }
            // 2の倍数, 3の倍数, 5の倍数, 7の倍数, ... を消す.
            // たたし, 例えば7の倍数の時 7*2, 7*3, 7*5 はすでに消えているので 7*7 start で OK.
            for (int j = i * i; j <= LIMIT; j = j + i) {
                isNotPrime[j] = true;
            }
        }
        final List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
            }
        }

        int acc = 0;
        final Map<Integer, Integer> memo = new HashMap<>();

        // Check prime^3 型.
        for (int i = 2; i * i * i <= LIMIT; i++) {
            if (!isNotPrime[i]) {
                memo.put(i * i * i, 1 + i + i * i + i * i * i);
            }
        }

        // Check (prime x prime), (1 x self) の組み合わせ.
        for (int num : nums) {
            if (memo.get(num) != null) {
                acc += memo.get(num);
                continue;
            }
            for (int p : primes) {
                // e.g., num=21 なら 4の倍数まで見ればいい. 5の倍数からは見なくて良い.
                if (p * p > num) {
                    break;
                }
                if (num % p == 0 && num != p && p != num / p && !isNotPrime[num / p]) {
                    final int sum = 1 + p + num + num / p;
                    memo.put(num, sum);
                    acc += sum;
                    break;
                }
            }
        }
        return acc;
    }
}
