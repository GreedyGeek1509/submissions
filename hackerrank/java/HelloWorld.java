import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Hello World
 */

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0,5).forEach(i -> {
            if (map.get(1) == null) {
                map.put(1, 1);
            } else {
                map.put(1, map.get(1)+1);
            }
        });
        System.out.println(map.get(1));
    }
}