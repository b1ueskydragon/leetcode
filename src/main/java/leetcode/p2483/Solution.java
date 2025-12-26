package leetcode.p2483;

class Solution {
    public int bestClosingTime(String customers) {
        // `N` : forward `N` count which not includes current `N` + backward `Y` count
        // `Y` : forward `N` count + backward `Y` count which includes current `Y`

        final int n = customers.length();
        final int[] Y = new int[n]; // Suffix count
        final int[] N = new int[n]; // Prefix count
        Y[n - 1] = customers.charAt(n - 1) == 'Y' ? 1 : 0;
        N[0] = customers.charAt(0) == 'N' ? 1 : 0;

        // Accumulate +1 or take over the previous count
        for (int i = n - 2; i >= 0; i--) {
            Y[i] = Y[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        for (int i = 1; i < n; i++) {
            N[i] = N[i - 1] + (customers.charAt(i) == 'N' ? 1 : 0);
        }

        final int[] penalties = new int[n + 1];
        penalties[0] = Y[0];
        penalties[n] = N[n - 1];
        for (int i = 1; i < n; i++) {
            penalties[i] = Y[i] + (customers.charAt(i) == 'N' ? N[i - 1] : N[i]);
        }

        int day = n;
        int min = penalties[n];
        for (int i = n - 1; i >= 0; i--) {
            if (penalties[i] <= min) {
                min = penalties[i];
                day = i; // Prefer to pick forward date
            }
        }
        return day;
    }
}
