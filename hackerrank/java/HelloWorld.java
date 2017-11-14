import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Hello World
 */

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println(Collections.nCopies(3, 45).stream().map(e -> e.toString()).collect(Collectors.joining()));
    }
}