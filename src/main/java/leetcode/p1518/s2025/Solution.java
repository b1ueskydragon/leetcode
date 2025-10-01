package leetcode.p1518.s2025;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int canDrink = numBottles;
        while (numBottles >= numExchange) {
            final int newBottles = numBottles / numExchange;
            canDrink += newBottles;
            numBottles = newBottles + (numBottles % numExchange);
        }
        return canDrink;
    }
}
