package leetcode.p1352;

import java.util.Arrays;

class ProductOfNumbers {

    // Constraint:
    // The product of any contiguous sequence of numbers will
    // fit into a single 32-bit integer without overflowing.
    //
    // -> Prefix Product is available, and indicates
    //    multiply-0-reset occurs frequently enough.

    // Preserve contiguous non-zero sections product.
    // e.g.,
    // 0 4 0 1 4 9 0 3 3 6 1
    // [4], [1 * 4 * 9], [3 * 3 * 6 * 1]
    private final int[] prefixNonZeroPrd;

    // e.g.,
    // 0 4 0 1 4 9 0 3 3 6 1
    // 0 0 2 2 2 2 6 6 6 6 6
    private int recentlySeenZeroIndex = -1;

    // The current position which increases
    // continuously without going backwards.
    private int i;

    public ProductOfNumbers() {
        // At most 4 * 10^4 calls will be made to add and getProduct.
        final int limit = 40_000;
        prefixNonZeroPrd = new int[limit + 2]; // includes sentinel
        // When encountering a zero, reset the product to 1, not to 0.
        Arrays.fill(prefixNonZeroPrd, 1);

        i = 0;
    }

    // O(1)
    public void add(int num) {
        if (num > 0) {
            prefixNonZeroPrd[i + 1] = prefixNonZeroPrd[i] * num;
        }
        if (num == 0) {
            recentlySeenZeroIndex = i;
        }
        i++;
    }

    // O(1)
    // The current list has at least k numbers.
    public int getProduct(int k) {
        // The get target range [i - k, i) includes at least one zero.
        if (recentlySeenZeroIndex >= i - k && recentlySeenZeroIndex < i) {
            return 0;
        }
        return prefixNonZeroPrd[i] / prefixNonZeroPrd[i - k];
    }
}
