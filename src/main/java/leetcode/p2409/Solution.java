package leetcode.p2409;

class Solution {
    // Arrival dates are earlier than or equal to leaving dates.
    // Non-leap year.

    private static final int[] MONTH_TO_DAYS =
            new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // [aliceFrom, aliceTo]
        final var aliceFrom = new Md(arriveAlice);
        final var aliceTo = new Md(leaveAlice);
        // [bobFrom, bobTo]
        final var bobFrom = new Md(arriveBob);
        final var bobTo = new Md(leaveBob);

        // The answer is [later arrive, earlier leave].
        final var from = aliceFrom.isLaterThan(bobFrom) ? aliceFrom : bobFrom;
        final var to = aliceTo.isEarlierThanOrEqualTo(bobTo) ? aliceTo : bobTo;

        // isLaterThan must exclude the equal case.
        if (from.isLaterThan(to)) {
            return 0;
        }

        int dates = 0;
        for (int m = from.month; m < to.month; m++) {
            dates += MONTH_TO_DAYS[m];
        }
        dates -= from.date - 1;
        dates += to.date;
        return dates;
    }

    private static class Md {
        int month;
        int date;

        Md(String mmdd) {
            final String[] tmp = mmdd.split("-");
            this.month = Integer.parseInt(tmp[0]);
            this.date = Integer.parseInt(tmp[1]);
        }

        boolean isLaterThan(Md other) {
            if (this.month < other.month) {
                return false;
            }
            if (this.month > other.month) {
                return true;
            }
            return this.date > other.date;
        }

        boolean isEarlierThanOrEqualTo(Md other) {
            return !isLaterThan(other);
        }
    }

}
