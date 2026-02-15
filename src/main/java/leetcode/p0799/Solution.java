package leetcode.p0799;

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        final double[][] tower = new double[102][102];
        // Top -> Bottom Directed Acyclic Graph.
        // ここを愚直に 1 からスタートすると頻繁に出戻り(前の状態の参照/更新)が発生するので,
        // 最初から全部を入れて下に流していく.
        tower[0][0] = poured;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                // 1 だけ残して, 残りは下にどんどん流す.
                double overflow = tower[i][j] - 1;
                if (overflow > 0) {
                    tower[i][j] = 1;
                    // どんどん accumulate するので List[] よりは 2D array が都合が良い.
                    tower[i + 1][j] += overflow / 2;
                    tower[i + 1][j + 1] += overflow / 2;
                }
                // overflow がない場合は, tower[i][j] で十分収容できている.
            }
        }
        return tower[query_row][query_glass];
    }
}
