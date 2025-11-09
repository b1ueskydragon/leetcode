package leetcode.p2169;

class Solution {
    public int countOperations(int num1, int num2) {
        if (num2 > num1) {
            // Swap to unify the status, num1 >= num2
            return countOperations(num2, num1);
        }
        int count = 0;
        while (num1 > 0 && num2 > 0) {
            int q = num1 / num2;
            int r = num1 % num2;

            count += q;
            num1 = num2;
            num2 = r;
        }
        return count;
    }
}
