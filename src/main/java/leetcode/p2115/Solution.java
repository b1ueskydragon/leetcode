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
        // Which should come first?
        final Set<String> baseSupplies = new HashSet<>();
        for (String s : supplies) {
            baseSupplies.add(s);
        }

        // recipes.length == ingredients.length
        final int n = recipes.length;

        // Recipe -> The number of dependencies (non-supply ingredients) should be resolved
        // Note:
        // - in-degree=0 represents `This recipe not depended on others at all`.
        // - Still we need to breakdown some ingredients but just count-up as 1. We can breakdown it later.
        final int[] inDegree = new int[n];

        // Non-supply ingredient -> Recipes
        // Note: We need to solve dependencies of non-supply ingredient later.
        final Map<String, List<String>> dependencyGraph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (String ing : ingredients.get(i)) {
                if (baseSupplies.contains(ing)) {
                    // No need to resolve the dependency.
                    continue;
                }
                dependencyGraph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipes[i]);
                inDegree[i]++;
            }
        }

        // Start with recipes that only need base supplies.
        // We will keep indices in here.
        final Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }

        final Map<String, Integer> recipeToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            recipeToIndex.put(recipes[i], i);
        }

        final List<String> createdRecipes = new ArrayList<>();
        while (!queue.isEmpty()) {
            // index
            final int i = queue.pollFirst();
            final String currRecipe = recipes[i];
            createdRecipes.add(currRecipe);

            if (!dependencyGraph.containsKey(currRecipe)) {
                // This recipe (`currRecipe`) cannot be an ingredient.
                continue;
            }

            // This recipe (`currRecipe`) can also act as an ingredient.
            // in other words, this may be blocking other recipes (`dependencyGraph#get`).
            for (String dependentRecipe : dependencyGraph.get(currRecipe)) {
                // `j` is an index of the `dependentRecipe` which depends on the `currRecipe`.
                final int j = recipeToIndex.get(dependentRecipe);
                // Since `currRecipe` is already in the queue, now we can resolve the dependency of `currRecipe`.
                // `currRecipe` is one of the dependencies of `dependentRecipe`
                inDegree[j]--;
                if (inDegree[j] == 0) {
                    queue.addLast(j);
                }
            }
        }

        return createdRecipes;
    }
}
