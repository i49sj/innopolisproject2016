import java.util.*;

/**
 * Created by innopolis on 13.11.16.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();
        Collections.sort(set, (o1, o2) -> o1.toString().compareTo(o2.toString()));
    }
}
