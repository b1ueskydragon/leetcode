package leetcode.p0380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

// Each function works in O(1) time complexity
// There will be at least one element in the data structure when getRandom is called
class RandomizedSet {

    // map val and location (position) on the list
    private final Map<Integer, Integer> map;
    // to get a random index. this keeps same elements between the map
    private final ArrayList<Integer> list;

    private final ThreadLocalRandom rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = ThreadLocalRandom.current();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            // nothing to add
            return false;
        }
        final int index = list.size();
        map.put(val, index);
        list.add(val);
        return true;
    }

    // move the removing element to the last
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            // nothing to remove
            return false;
        }
        final int index = map.get(val);
        final int last = list.size() - 1;
        if (index < last) {
            // swap the last and the current
            // order is not matter since all elements are get randomly
            // arraylist's #set #get work in O(1) time complexity
            final int currLastVal = list.get(last);
            list.set(index, currLastVal);
            map.put(currLastVal, index);
        }
        map.remove(val);
        // arraylist's removing last elements only takes O(1) time complexity
        // since 'System#arraycopy will be skipped
        list.remove(last);
        return true;
    }

    public int getRandom() {
        final int maxBound = list.size();
        return list.get(rand.nextInt(maxBound));
    }
}
