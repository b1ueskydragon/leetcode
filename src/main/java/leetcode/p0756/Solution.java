package leetcode.p0756;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    // 同じ bottom が何度も出てくるため.
    // 現在の bottom が top (length 1) まで到達できるかどうか.
    private final Map<String, Boolean> memo = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // List -> Map
        // e.g.,
        // AAB, AAC, BCD, BBE, DEF
        // AA -> [B, C]
        // BC -> [D]
        // BB -> [E]
        // DE -> [F]
        final Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            final String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        return find(bottom, map);
    }

    private boolean find(String bottom, Map<String, List<Character>> map) {
        if (memo.get(bottom) != null) {
            return memo.get(bottom);
        }
        // e.g.,
        // bottom = BCD
        // (1) Find BC, CD (BC -> [C], CD -> [E])
        // (2) Build a new bottom, Now the bottom = CE
        if (bottom.length() == 1) {
            // Base case (1): Reached the top.
            memo.put(bottom, true);
            return true;
        }
        final var candidates = getCandidates(bottom, map);
        if (candidates.isEmpty()) {
            // Base case (2): Cannot build the next level from this bottom.
            memo.put(bottom, false);
            return false;
        }
        final List<String> bottoms = new ArrayList<>(); // Create new instance for every stage.
        construct(candidates, new StringBuilder(), 0, bottoms);
        for (String b : bottoms) {
            if (find(b, map)) {
                // Short-circuit. Any successful path is enough.
                memo.put(bottom, true);
                return true;
            }
        }
        memo.put(bottom, false);
        return false;
    }

    private List<List<Character>> getCandidates(String bottom, Map<String, List<Character>> map) {
        final List<List<Character>> list = new ArrayList<>();
        final int n = bottom.length();
        for (int i = 0; i < n - 1; i++) {
            final String key = bottom.substring(i, i + 2);
            if (!map.containsKey(key)) {
                return List.of();
            }
            list.add(map.get(key));
        }
        return list;
    }

    private void construct(
            List<List<Character>> candidates,
            StringBuilder current,
            int index,
            List<String> results
    ) {
        if (index == candidates.size()) {
            results.add(current.toString());
            return;
        }
        // For-loop: 横の探索 (現在の index).
        for (char choice : candidates.get(index)) {
            current.append(choice); // Choice.
            // Recursion: 縦の探索 (現在の index で選び終わったので, 次の index へ深く進む).
            construct(candidates, current, index + 1, results);
            current.deleteCharAt(current.length() - 1); // Remove the choice.
        }
    }
}
