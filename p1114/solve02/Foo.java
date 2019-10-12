package leetcode.p1114.solve02;

import java.util.concurrent.Semaphore;

class Foo {
  private final Semaphore runNext = new Semaphore(0);
  private final Semaphore runFinal = new Semaphore(0);

  public void first(Runnable printFirst) throws InterruptedException {
    printFirst.run();
    runNext.release();
  }

  public void second(Runnable printSecond) throws InterruptedException {
    runNext.acquire();
    printSecond.run();
    runFinal.release();
  }

  public void third(Runnable printThird) throws InterruptedException {
    runFinal.acquire();
    printThird.run();
  }
}
