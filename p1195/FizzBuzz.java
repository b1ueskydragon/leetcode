package leetcode.p1195;

import java.util.function.IntConsumer;

class FizzBuzz {
  private int n;
  private volatile int value = 1;

  public FizzBuzz(int n) {
    this.n = n;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    while (value <= n) {
      int x = value;
      if (x % 3 == 0 && x % 5 != 0) {
        printFizz.run();
        value++; // increment only fit to condition and after run
      }
    }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    while (value <= n) {
      int x = value;
      if (x % 5 == 0 && x % 3 != 0) {
        printBuzz.run();
        value++; // increment only fit to condition and after run
      }
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    while (value <= n) {
      int x = value;
      if (x % 15 == 0) {
        printFizzBuzz.run();
        value++; // increment only fit to condition and after run
      }
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    while (value <= n) {
      int x = value;
      if (x % 3 != 0 && x % 5 != 0) {
        printNumber.accept(x);
        value++; // increment only fit to condition and after run
      }
    }
  }

}
