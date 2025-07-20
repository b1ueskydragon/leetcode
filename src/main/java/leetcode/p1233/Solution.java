package leetcode.p1233;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // To not remove previous added element from the result,
        // Make sure sorting to ascending order
        // e.g., "/a" should be ordered first than "/a/b"
        Arrays.sort(folder);
        final var parents = new LinkedList<String>();
        parents.addLast(folder[0]);
        for (String paths : folder) {
            final String[] path = paths.split("/");
            final var chain = new StringBuilder();
            for (int i = 1; i < path.length; i++) {
                chain.append("/");
                chain.append(path[i]);
                final String p = chain.toString();
                if (parents.peekLast().equals(p)) {
                    break;
                }
            }
            final String p = chain.toString();
            if (!parents.peekLast().equals(p)) {
                parents.addLast(p);
            }
        }
        return parents;
    }
}
