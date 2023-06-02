package leetcode.p1114.solve01;

import java.util.concurrent.atomic.AtomicInteger;

class Foo {

  private final AtomicInteger firstJobDone = new AtomicInteger(0);
  private final AtomicInteger secondJobDone = new AtomicInteger(0);

  public Foo() { }

  public void first(Runnable printFirst) throws InterruptedException {
    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    firstJobDone.incrementAndGet();
  }

  public void second(Runnable printSecond) throws InterruptedException {
    while (firstJobDone.get() == 0) { /* waiting */ }
    // printSecond.run() outputs "second". Do not change or remove this line.
    firstJobDone.decrementAndGet();
    printSecond.run();
    secondJobDone.incrementAndGet();
  }

  public void third(Runnable printThird) throws InterruptedException {
    while (secondJobDone.get() == 0) { /* waiting */ }
    // printThird.run() outputs "third". Do not change or remove this line.
    secondJobDone.decrementAndGet();
    printThird.run();
  }

}
