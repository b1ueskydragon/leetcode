package leetcode.p2115;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    // Constraints:
    // You have an infinite supply of all of them.
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Constraints: max 100 length;
        final int n = recipes.length;
        final Map<String, List<String>> recipeToIngredient = new HashMap<>();
        for (int i = 0; i < n; i++) {
            recipeToIngredient.put(recipes[i], ingredients.get(i));
        }

        final Map<String, Set<String>> flatten = new HashMap<>();

        for (var entry : recipeToIngredient.entrySet()) {
            // Constraints: max 10 size
            //
            // flatten
            // e.g.,
            // recipes=["bread","sandwich","burger","bigburger"]
            // ingredients=[["yeast","flour"],["bread","meat"],["sandwich","meat","bread"],["burger","bread"]]
            //
            // bigburger
            // = burger,bread
            // = bread,          sandwich,meat,bread
            // = sandwich,meat,bread,                yeast,flour
            // = ...
            final Deque<String> queue = new ArrayDeque<>(entry.getValue());

            while (!queue.isEmpty()) {
                final String ingredient = queue.pollFirst();
                final List<String> rs = recipeToIngredient.get(ingredient);
                if (rs == null) {
                    flatten.computeIfAbsent(entry.getKey(), k -> new HashSet<>()).add(ingredient);
                } else {
                    queue.addAll(rs);
                }
            }
        }

        final List<String> possibleRecipes = new ArrayList<>();
        for (var entry : flatten.entrySet()) {
            final Set<String> needed = entry.getValue();
            final Set<String> tmp = new HashSet<>(needed);
            for (String s : supplies) {
                if (needed.contains(s)) {
                    tmp.remove(s);
                }
            }
            if (tmp.size() == 0) {
                possibleRecipes.add(entry.getKey());
            }
        }

        return possibleRecipes;
    }
}
