package leetcode.p0657;

class Solution {
    public boolean judgeCircle(String moves) {
        int upStack = 0;
        int rightStack = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U' -> upStack++;
                case 'D' -> upStack--;
                case 'R' -> rightStack++;
                case 'L' -> rightStack--;
            }
        }
        return upStack == 0 && rightStack == 0;
    }
}
