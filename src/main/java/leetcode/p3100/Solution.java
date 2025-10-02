package leetcode.p3100;

class Solution {
    // Operation:
    // - Drink any number of full water bottles turning them into empty bottles.
    // OR
    // - Exchange numExchange empty bottles with one full water bottle. Then, increase numExchange by one.
    // e.g.,
    // if numBottles == 3 and numExchange == 1,
    // you cannot exchange 3 empty water bottles for 3 full bottles.
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        // Per 1 operation, we only can obtain 1 new bottle. We can't obtain multiple bottles in one operation.
        // -> Do exchanging operation as many as possible.
        // -> Consume first `numExchange` which can exchange to 1 new bottle.
        int canDrink = 0;
        while (numBottles >= numExchange) {
            canDrink += numExchange;
            numBottles = numBottles - numExchange + 1;
            numExchange++;
        }
        return canDrink + numBottles;
    }
}
