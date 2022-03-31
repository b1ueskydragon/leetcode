package leetcode.p0500;

import java.util.Set;

class Solution {
    private static final Set<Character> thirdRow = Set.of('z', 'x', 'c', 'v', 'b', 'n', 'm');
    private static final Set<Character> secondRow = Set.of('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');

    public String[] findWords(String[] words) {
        int count = words.length;
        for (int i = 0; i < words.length; i++) {
            final String word = words[i];
            final int head = selectRow(word.charAt(0));
            for (int j = 1; j < word.length(); j++) {
                if (head == selectRow(word.charAt(j))) continue;
                words[i] = null;
                count--;
                break;
            }
        }

        final String[] filtered = new String[count];
        int i = 0;
        for (String word : words) {
            if (word != null) filtered[i++] = word;
        }

        return filtered;
    }

    private static int selectRow(char target) {
        if (target < 97) target += 32;
        if (thirdRow.contains(target)) return 3;
        if (secondRow.contains(target)) return 2;
        return 1;
    }
}
