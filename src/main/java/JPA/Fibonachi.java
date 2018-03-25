package JPA;

/**
 * Created by User on 04.12.2016.
 */
public class Fibonachi implements Runnable{
    static int sum;
    public static int fib(int a1, int a2){
        sum = a1 + a2;
        a1 = a2;
        a2 = sum;
        System.out.println(sum);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return fib(a1, a2);
    }

    @Override
    public void run() {
        fib(0, 1);
    }
}
