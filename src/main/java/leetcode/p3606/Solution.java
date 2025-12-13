package leetcode.p3606;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {

    private static final Map<String, Integer> LINES =
            Map.of("electronics", 0, "grocery", 1, "pharmacy", 2, "restaurant", 3);

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        final List<Pair> answer = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i] || !LINES.containsKey(businessLine[i]) || !isMatched(code[i])) {
                continue;
            }
            answer.add(new Pair(code[i], LINES.get(businessLine[i])));
        }

        answer.sort((a, b) -> (a.priority == b.priority) ? a.code.compareTo(b.code) : a.priority - b.priority);
        return answer.stream().map(p -> p.code).toList();
    }

    private record Pair(String code, int priority) {
    }

    private static boolean isMatched(String s) {
        for (char c : s.toCharArray()) {
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_')) {
                return false;
            }
        }
        return !s.isEmpty();
    }

}
