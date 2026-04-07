package leetcode.p0874;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        final Map<Integer, List<Integer>> xMap = new HashMap<>();
        final Map<Integer, List<Integer>> yMap = new HashMap<>();
        for (int[] obstacle : obstacles) {
            int i = obstacle[0];
            int j = obstacle[1];
            if (xMap.get(i) == null) {
                xMap.put(i, new ArrayList<>());
            }
            xMap.get(i).add(j);
            if (yMap.get(j) == null) {
                yMap.put(j, new ArrayList<>());
            }
            yMap.get(j).add(i);
        }
        // Prepare to binary search.
        for (List<Integer> v : xMap.values()) {
            Collections.sort(v);
        }
        for (List<Integer> v : yMap.values()) {
            Collections.sort(v);
        }

        int i = 0;
        int j = 0;
        int best = 0;

        // n, s, e, w
        char direction = 'n';
        for (int command : commands) {
            if (command == -1) {
                switch (direction) {
                    case 'n' -> direction = 'e';
                    case 's' -> direction = 'w';
                    case 'e' -> direction = 's';
                    case 'w' -> direction = 'n';
                }
            } else if (command == -2) {
                switch (direction) {
                    case 'n' -> direction = 'w';
                    case 's' -> direction = 'e';
                    case 'e' -> direction = 'n';
                    case 'w' -> direction = 's';
                }
            } else {
                switch (direction) {
                    case 'n' -> {
                        // x can be fixed. key is x.
                        // restrict y-axis. restriction target is y.
                        if (xMap.get(i) != null) {
                            int limit = lowerBoundBS(j, xMap.get(i));
                            // target 以上の点のなかで最も小さい点 - 1.
                            // なお, limit - 1 の結果が現在の位置より低い場合は invalid なので普通に command 分進む.
                            // e.g., (0, 0) 出発, (0, 0) obstacle.
                            if (limit >= j && j + command >= limit && limit - 1 >= j) {
                                j = limit - 1;
                            } else {
                                j += command;
                            }
                        } else {
                            j += command;
                        }
                    }
                    case 's' -> {
                        // x can be fixed. key is x.
                        // restrict y-axis. restriction target is y.
                        if (xMap.get(i) != null) {
                            int limit = upperBoundBS(j, xMap.get(i));
                            // target 以下の点で最も大きい点 + 1.
                            if (limit <= j && j - command <= limit && limit + 1 <= j) {
                                j = limit + 1;
                            } else {
                                j -= command;
                            }
                        } else {
                            j -= command;
                        }
                    }
                    case 'e' -> {
                        // y can be fixed. key is y.
                        // restrict x-axis. restriction target is x.
                        if (yMap.get(j) != null) {
                            int limit = lowerBoundBS(i, yMap.get(j));
                            // target 以上の点のなかで最も小さい点 - 1.
                            if (limit >= i && i + command >= limit && limit - 1 >= i) {
                                i = limit - 1;
                            } else {
                                i += command;
                            }
                        } else {
                            i += command;
                        }
                    }
                    case 'w' -> {
                        // y can be fixed. key is y.
                        // restrict x-axis. restriction target is x.
                        if (yMap.get(j) != null) {
                            int limit = upperBoundBS(i, yMap.get(j));
                            // target 以下の点のなかで最も大きい点 + 1.
                            if (limit <= i && i - command <= limit && limit + 1 <= i) {
                                i = limit + 1;
                            } else {
                                i -= command;
                            }
                        } else {
                            i -= command;
                        }
                    }
                }
                best = Math.max(best, i * i + j * j);
            }

        }

        return best;
    }

    // target 以上の中で最も target に近い点.
    private int lowerBoundBS(int target, List<Integer> cands) {
        int l = 0;
        int r = cands.size() - 1; // r is inclusive.

        while (l < r) {
            // left-aligned center. do not fix the left in the middle.
            int m = l + (r - l) / 2;
            if (cands.get(m) >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        // Target より小さい可能性あり, 呼び出し側で制御する.
        return cands.get(r);
    }

    // target 以下の中で最も target に近い点.
    private int upperBoundBS(int target, List<Integer> cands) {
        int l = 0;
        int r = cands.size(); // r is exclusive.

        while (l < r) {
            int m = l + (r - l) / 2;
            if (cands.get(m) <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        // Target より大きい可能性あり, 呼び出し側で制御する.
        return l < 1 ? cands.get(0) : cands.get(l - 1);
    }
}
