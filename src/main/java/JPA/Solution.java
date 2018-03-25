package JPA;

/**
 * Created by User on 04.12.2016.
 */
public class Solution {

    public static void main(String[] args) {
        Fibonachi f = new Fibonachi();
        Thread t = new Thread(f);
        t.start();
    }
}
