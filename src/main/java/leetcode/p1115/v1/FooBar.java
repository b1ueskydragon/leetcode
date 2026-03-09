package leetcode.p1115.v1;

import java.util.concurrent.atomic.AtomicInteger;

class FooBar {
    private final AtomicInteger n;

    public FooBar(int n) {
        // even count: foo
        // odd count: bar
        this.n = new AtomicInteger(n * 2);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        // Pick n th, n-2 th, ... , 2nd (0-th is redundant).
        while (n.intValue() > 1) {
            if ((n.intValue() & 1) == 0) {
                printFoo.run();
                n.decrementAndGet();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        // Pick n-1 th, n-3 th, ... , 1st.
        while (n.intValue() > 0) {
            if ((n.intValue() & 1) == 1) {
                printBar.run();
                n.decrementAndGet();
            }
        }
    }
}
