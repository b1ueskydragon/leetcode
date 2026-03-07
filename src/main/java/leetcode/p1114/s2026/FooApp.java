package leetcode.p1114.s2026;

class FooApp {
    public static void main(String[] args) {
        Foo foo = new Foo();

        // Execution threads.
        // Executed in any order, must print out "firstsecondthird".

        // Thread#start creates a new thread.
        // In that case, the run method will execute in that new thread, not in the main thread.

//        while (!Thread.currentThread().isInterrupted()) {
        // Thread3 and start
        new Thread(() -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                // Interrupt flag.
                Thread.currentThread().interrupt();
            }
        }).start();

        // Thread2 and start
        new Thread(() -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                // Interrupt flag.
                Thread.currentThread().interrupt();
            }
        }).start();

        // Thread1 and start
        new Thread(() -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                // Interrupt flag.
                Thread.currentThread().interrupt();
            }
        }).start();
//        }

    }
}
