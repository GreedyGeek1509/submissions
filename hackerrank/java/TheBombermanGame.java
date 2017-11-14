import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/bomber-man/problem
 */

public class TheBombermanGame {

    static Function<List<? extends Object>,String> listToString = l -> l.stream().map(e -> e.toString()).collect(Collectors.joining());

    static Consumer<List<? extends  Object>> printList = l -> System.out.println(listToString.apply(l));

    static List<String> map = new ArrayList<>();

    static int R,C,N;

    static boolean isNotSafe(int r, int c) {
        return (r > 0 && map.get(r-1).charAt(c) == 'O') || (c > 0 && map.get(r).charAt(c-1) == 'O')
                || (r < R-1 && map.get(r+1).charAt(c) == 'O')
                || (c < C-1 && map.get(r).charAt(c+1) == 'O')
                || map.get(r).charAt(c) == 'O';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();
        N = scanner.nextInt();

        IntStream.range(0, R).forEach(r -> map.add(scanner.next()));

        if (N%2 == 0) {
            IntStream.range(0, R).forEach(r -> printList.accept(Collections.nCopies(C, 'O')));
        } else if ((N-1)%4 == 0) {
            map.stream().forEach(System.out::println);
        } else {
            IntStream.range(0,R).forEach(r -> {
                IntStream.range(0, C).forEach(c -> {
                    if (isNotSafe(r, c)) {
                        System.out.print('.');
                    } else {
                        System.out.print('O');
                    }
                });
                System.out.println();
            });
        }
    }
}
