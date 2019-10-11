package leetcode.p1114.solve01.app;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Arranged to enable local execution
 */
public class FooApp {

  private static final Foo foo = new Foo();

  public static void main(String[] args) {

    Thread t1 = new Thread(foo::first);
    Thread t2 = new Thread(foo::second);
    Thread t3 = new Thread(foo::third);

    t3.start();
    t2.start();
    t1.start();
  }

}

class Foo {

  private final AtomicBoolean hasFirstDone = new AtomicBoolean(false);
  private final AtomicBoolean hasSecondDone = new AtomicBoolean(false);

  public void first() {
    System.out.print("first");
    hasFirstDone.set(true);
  }

  public void second() {
    while (!hasFirstDone.get()) {
      // System.out.println("t2 waits");
      // no-op
    }
    System.out.print("second");
    hasSecondDone.set(true);
  }

  public void third() {
    while (!hasSecondDone.get()) {
      // System.out.println("t3 waits");
      // no-op
    }
    System.out.print("third");
  }

}
