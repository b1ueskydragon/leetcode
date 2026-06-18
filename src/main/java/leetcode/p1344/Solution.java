package leetcode.p1344;

class Solution {
    // 1 <= hour <= 12, 0 <= minutes <= 59
    public double angleClock(int hour, int minutes) {

        // init: 00:00
        // minute: 6 degrees / min
        // hour: 30 degrees / hour,  0.5 degrees / min
        // e.g.,
        // 12:30
        // minute: 180 degrees
        // hour: 0 degree (360 degrees) + 15 degrees
        // 360 - (180 + 15) = 165
        // or 180 - 15 = 165

        double minDegrees = minutes * 6;
        double hourDegrees = (hour * 30) + (0.5d * minutes);

        double diff = Math.abs(hourDegrees - minDegrees);

        return diff > 180 ? 360 - diff : diff;
    }
}
