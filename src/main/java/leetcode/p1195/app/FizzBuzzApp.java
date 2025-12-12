package leetcode.p1195.app;

import java.util.concurrent.atomic.AtomicInteger;

class FizzBuzzApp {

  private static final FizzBuzz instance = new FizzBuzz(30);

  public static void main(String[] args) {
    Thread t1 = new Thread(instance::printFizz);
    Thread t2 = new Thread(instance::printBuzz);
    Thread t3 = new Thread(instance::printFizzBuzz);
    Thread t4 = new Thread(instance::printNumber);
    t3.start();
    t2.start();
    t1.start();
    t4.start();
  }

}

class FizzBuzz {

  private int n;
  private AtomicInteger syncNum = new AtomicInteger(1);

  public FizzBuzz(int n) {
    this.n = n;
  }

  public void printFizz() {
    while (true) {
      int x = syncNum.get();
      if (x > n) return;
      if (x % 3 == 0 && x % 5 != 0) {
        System.out.println("fizz");
        syncNum.incrementAndGet();
      }
    }
  }

  public void printBuzz() {
    while (true) {
      int x = syncNum.get();
      if (x > n) return;
      if (x % 5 == 0 && x % 3 != 0) {
        System.out.println("buzz");
        syncNum.incrementAndGet();
      }
    }

  }

  public void printFizzBuzz() {
    while (true) {
      int x = syncNum.get();
      if (x > n) return;
      if (x % 15 == 0) {
        System.out.println("fizzbuzz");
        syncNum.incrementAndGet();
      }
    }
  }

  public void printNumber() {
    while (true) {
      int x = syncNum.get();
      if (x > n) return;
      if (x % 3 != 0 && x % 5 != 0) {
        System.out.println(x);
        syncNum.incrementAndGet();
      }
    }
  }

}
