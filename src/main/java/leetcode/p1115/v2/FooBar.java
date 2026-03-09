package leetcode.p1115.v2;

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;

    // Can execute 1 thread simultaneously.
    // Behave as synchronized mutex.
    // 1 にすることで最初の「誰か」を必ず起こせる.
    private Semaphore fooLock = new Semaphore(1);

    // 0 permit. Waiting release from any other Thread.
    // #acquire from the waiting thread, #release from the other notifying thread.
    //　Permit がないので acquire できず, 結果的に一度 acquire すると別の誰かが release してくれるまで wait forever.
    private Semaphore barLock = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // Acquire permit. Permit: 1->0.
            fooLock.acquire();
            // After permit 1->0, executable.
            printFoo.run();
            // notify to the bar thread.
            // barLock を持っている bar しか起きない.
            barLock.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // Wait until someone releases the permit.
            barLock.acquire();
            // Someone released the barLock, executable.
            printBar.run();
            // release the permit. Permit: 0->1.
            // notify to the foo thread.
            // fooLock を持っている foo しか起きない.
            fooLock.release();
        }
    }
}
