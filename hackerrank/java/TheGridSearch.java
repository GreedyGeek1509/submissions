import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TheGridSearch {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        IntStream.range(0, T).forEach(t -> {
            int R,C,r,c;
            List<String> grid = new ArrayList<>();
            List<String> pattern = new ArrayList<>();
            R = scanner.nextInt();
            C = scanner.nextInt();

            IntStream.range(0, R).forEach(row -> grid.add(scanner.next()));

            r = scanner.nextInt();
            c = scanner.nextInt();

            IntStream.range(0, r).forEach(row -> pattern.add(scanner.next()));

        });
    }
}
