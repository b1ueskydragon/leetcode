package leetcode.p1114.s2026;

class Foo {
    private final Lock lock;

    private static class Lock {
        boolean isFirstLocked;
        boolean isSecondLocked;
        boolean isThirdLocked;

        Lock(boolean isFirstLocked, boolean isSecondLocked, boolean isThirdLocked) {
            this.isFirstLocked = isFirstLocked;
            this.isSecondLocked = isSecondLocked;
            this.isThirdLocked = isThirdLocked;
        }
    }

    public Foo() {
        lock = new Lock(false, true, true);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            while (lock.isFirstLocked) {
                lock.wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();

            // Release the next step.
            lock.isSecondLocked = false;

            // Lock other steps.
            lock.isFirstLocked = true;
            lock.isThirdLocked = true;

            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (lock.isSecondLocked) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();

            // Release the next step.
            lock.isThirdLocked = false;

            // Lock other steps.
            lock.isFirstLocked = true;
            lock.isSecondLocked = true;

            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (lock.isThirdLocked) {
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

            // Codes below are not necessary since the third is the last step.

            // Release the next step.
            lock.isFirstLocked = false;

            // Lock other steps.
            lock.isThirdLocked = true;
            lock.isSecondLocked = true;

            lock.notifyAll();
        }
    }
}
