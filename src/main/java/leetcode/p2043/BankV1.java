package leetcode.p2043;

import java.util.HashMap;
import java.util.Map;

class BankV1 {

    // 1-based index
    // Account -> Balance
    final Map<Integer, Long> map = new HashMap<>();

    public BankV1(long[] balance) {
        for (int i = 0; i < balance.length; i++) {
            map.put(i + 1, balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if (map.get(account1) == null || map.get(account2) == null) {
            return false;
        }
        if (map.get(account1) < money) {
            return false;
        }
        map.put(account1, map.get(account1) - money);
        map.put(account2, map.get(account2) + money);
        return true;
    }

    public boolean deposit(int account, long money) {
        if (map.get(account) == null) {
            return false;
        }
        map.put(account, map.get(account) + money);
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (map.get(account) == null || map.get(account) < money) {
            return false;
        }
        map.put(account, map.get(account) - money);
        return true;
    }

}
