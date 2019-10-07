package leetcode.p1195;

import java.util.function.IntConsumer;

class FizzBuzz {
  private int n;

  public FizzBuzz(int n) {
    this.n = n;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    System.out.println("fizz");
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    System.out.println("buzz");
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    System.out.println("fizzbuzz");
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    System.out.println(n);
  }

  // TODO Spec
  public static void main(String[] args) throws Exception {
    final var fizzBuzz = new FizzBuzz(15);

    Thread printFizz = new Thread();
    Thread printBuzz = new Thread();
    Thread printFizzBuzz = new Thread();
    IntConsumer printNumber = value -> new Thread();

    fizzBuzz.fizz(printFizz);
    fizzBuzz.buzz(printBuzz);
    fizzBuzz.fizzbuzz(printFizzBuzz);
    fizzBuzz.number(printNumber);

    // expected
    // 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz
  }

}
