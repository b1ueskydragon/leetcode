package leetcode.p0380;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

// Each function works in O(1) time complexity
// There will be at least one element in the data structure when getRandom is called
class RandomizedSet {
    private final Set<Integer> mainSet;

    // tracking
    // backUp only interested in adding elements
    // this allowing duplications. if the number added repeatedly, a probability of selection may increase
    private final List<Integer> backUp;
    private final Set<Integer> removed;

    private final ThreadLocalRandom rand;

    public RandomizedSet() {
        mainSet = new HashSet<>();
        backUp = new ArrayList<>();
        removed = new HashSet<>();
        rand = ThreadLocalRandom.current();
    }

    public boolean insert(int val) {
        final boolean notExists = mainSet.add(val);
        if (notExists) {
            backUp.add(val);
        }
        removed.remove(val);
        return notExists;
    }

    public boolean remove(int val) {
        final boolean exists = mainSet.remove(val);
        if (exists) {
            removed.add(val);
        }
        return exists;
    }

    public int getRandom() {
        final int maxBound = backUp.size();
        Integer cand = backUp.get(rand.nextInt(maxBound));
        while (removed.contains(cand)) {
            cand = backUp.get(rand.nextInt(maxBound));
        }
        return cand;
    }
}
