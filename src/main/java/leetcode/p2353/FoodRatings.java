package leetcode.p2353;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FoodRatings {

    // food -> cuisine
    private final Map<String, String> foodToCuisine = new HashMap<>();
    // cuisine -> ranking/lexicographical order priority queue
    private final Map<String, PriorityQueue<Food>> cuisineToFood = new HashMap<>();
    private final Map<String, Integer> foodRevision = new HashMap<>();

    private static class Food {
        int rate;
        String name;
        int version; // revision. at most 20000 calls in total

        Food(int rate, String name, int version) {
            this.rate = rate;
            this.name = name;
            this.version = version;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        final int n = foods.length;
        for (int i = 0; i < n; i++) {
            // All the strings in foods are distinct.
            String foodName = foods[i];
            String cuisine = cuisines[i];
            foodToCuisine.put(foodName, cuisine);
            cuisineToFood.computeIfAbsent(cuisine,
                            k -> new PriorityQueue<>((f1, f2) -> (f1.rate == f2.rate) ? f1.name.compareTo(f2.name) : f2.rate - f1.rate))
                    .offer(new Food(ratings[i], foodName, 0));
            foodRevision.put(foodName, 0);
        }
    }

    public void changeRating(String food, int newRating) {
        final String cuisine = foodToCuisine.get(food);
        if (cuisine == null) {
            return;
        }
        final var pq = cuisineToFood.get(cuisine);
        if (pq == null) {
            return; // maybe an exception
        }
        foodRevision.put(food, foodRevision.getOrDefault(food, 0) + 1);
        pq.offer(new Food(newRating, food, foodRevision.get(food)));
    }

    public String highestRated(String cuisine) {
        final var pq = cuisineToFood.get(cuisine);
        if (pq == null) {
            return "";
        }
        if (pq.peek() == null) {
            return "";
        }
        // In this problem, a valid item in the queue should not be removed
        Food cand = pq.peek();
        while (cand.version != foodRevision.getOrDefault(cand.name, 0)) {
            pq.poll();
            cand = pq.peek();
        }
        return cand.name;
    }
}
