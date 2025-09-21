package leetcode.p3508;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Router {

    // Note that queries for addPacket will be made in increasing order of timestamp.

    private final ArrayDeque<int[]> dq;
    private final int capacity;
    private final Set<String> added;
    // dest -> timestamps (sorted asc)
    private final Map<Integer, List<Integer>> destMap;
    // dest -> the oldest time
    private final Map<Integer, Integer> destHead = new HashMap<>();

    public Router(int memoryLimit) {
        this.dq = new ArrayDeque<>();
        this.capacity = memoryLimit;
        this.added = new HashSet<>();
        this.destMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        final String key = buildKey(source, destination, timestamp);
        if (added.contains(key)) {
            return false;
        }
        if (capacity == dq.size()) {
            final int[] head = dq.pollFirst();
            added.remove(buildKey(head[0], head[1], head[2]));
            // update the destination head of destMap.get(destination)
            destHead.put(head[1], destHead.getOrDefault(head[1], 0) + 1);
        }
        added.add(key);
        dq.addLast(new int[]{source, destination, timestamp});
        destMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    // 必ず古いものが抜けていく
    public int[] forwardPacket() {
        // LRU cache のように一度引いたものを再度先頭に戻したりはしないので double-pointer node 実装は不要.
        if (dq.peek() == null) {
            return new int[]{};
        }
        final int[] head = dq.pollFirst();
        added.remove(buildKey(head[0], head[1], head[2]));
        destHead.put(head[1], destHead.getOrDefault(head[1], 0) + 1);
        return head;
    }

    public int getCount(int destination, int startTime, int endTime) {
        // dest が ts よりパターン数が少ないので dest を key とする map から引く
        if (!destMap.containsKey(destination)) {
            return 0;
        }
        // binary search
        final List<Integer> timelapse = destMap.get(destination);

        // find target: startTime (必ずしも同じ値が見つかるわけではない)
        int start;
        {
            int l = destHead.getOrDefault(destination, 0);
            int r = timelapse.size();

            while (l < r) {
                int m = l + (r - l) / 2;
                if (timelapse.get(m) >= startTime) {
                    // m は左寄りなので l は m に固定しない (l=m はカーソルが動かなくなる恐れあり)
                    r = m;
                } else {
                    // m は左寄りなので l=m と l は m に固定しない
                    l = m + 1;
                }
            }
            start = r;
        }

        // find target: endTime (必ずしも同じ値が見つかるわけではない)
        int end;
        {
            int l = destHead.getOrDefault(destination, 0);
            int r = timelapse.size();

            while (l < r) {
                int m = l + (r - l) / 2;
                if (timelapse.get(m) <= endTime) {
                    // m は左寄りなので l は m に固定しない (l=m はカーソルが動かなくなる恐れあり)
                    l = m + 1;
                } else {
                    // 候補になり得るので動かさない
                    r = m;
                }
            }
            end = l - 1;
        }

        return (end >= start) ? end - start + 1 : 0;
    }

    private static String buildKey(int source, int destination, int timestamp) {
        final var sb = new StringBuilder();
        sb.append(source);
        sb.append(":");
        sb.append(destination);
        sb.append(":");
        sb.append(timestamp);
        return sb.toString();
    }
}
