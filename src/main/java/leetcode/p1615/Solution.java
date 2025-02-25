package leetcode.p1615;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        // node -> the number of the node's friends
        // mapping: index is node, value is the number of its friends
        // Constraints: n is at most 100 and 同じ node は無い, 自分自身とは友達にならない, so we can use an array instead of hashmap
        int[] friendsNumber = new int[n];
        boolean[][] coFriends = new boolean[n][n];
        for (int[] pair : roads) {
            // 重複 count (coFriends) is allowed at this time
            friendsNumber[pair[0]]++;
            friendsNumber[pair[1]]++;

            coFriends[pair[0]][pair[1]] = true;
            coFriends[pair[1]][pair[0]] = true;
        }

        int maxRank = 0;
        for (int left = 0; left < n; left++) {
            int leftCount = friendsNumber[left];
            for (int right = left + 1; right < n; right++) {
                int rightCount = friendsNumber[right];
                int currRank = leftCount + rightCount;
                if (coFriends[left][right] || coFriends[right][left]) {
                    currRank -= 1;
                }
                maxRank = Math.max(maxRank, currRank);
            }
        }
        return maxRank;
    }
}
