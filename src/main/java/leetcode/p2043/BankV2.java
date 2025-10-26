package leetcode.p2043;

class BankV2 {

    // 1-based index
    // Account -> Balance
    final Long[] map = new Long[100_001];

    public BankV2(long[] balance) {
        for (int i = 0; i < balance.length; i++) {
            map[i + 1] = balance[i];
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if (map[account1] == null || map[account1] < money) {
            return false;

        }
        if (map[account2] == null) {
            return false;
        }
        map[account1] -= money;
        map[account2] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (map[account] == null) {
            return false;
        }
        map[account] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (map[account] == null || map[account] < money) {
            return false;
        }
        map[account] -= money;
        return true;
    }

}
