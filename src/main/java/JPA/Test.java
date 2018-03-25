package JPA;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by User on 07.12.2016.
 */
public class Test {
    public static class MyThread extends Thread {
        static AtomicInteger counter = new AtomicInteger(0);

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.addAndGet(1);
            }
        }


        public static void main(String[] args) throws InterruptedException {
            MyThread t1 = new MyThread();
            MyThread t2 = new MyThread();
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println(counter.get());
        }

    }
}
