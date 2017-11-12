import java.util.*;
import java.util.stream.IntStream;

public class OrganizingContainersOfBalls {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int nq = 0; nq < q; nq++) {
            int n = scanner.nextInt();

            List<List<Integer>> matrix = new ArrayList<>();

            Map<Integer, Integer> countMap = new HashMap<>();

            IntStream.range(0, n).forEach(r -> {
                matrix.add(new ArrayList<>());
                IntStream.range(0, n).forEach(c -> {
                    matrix.get(r).add(scanner.nextInt());
                });
            });

            IntStream.range(0, n).forEach(r -> {
                int sum = matrix.get(r).stream().mapToInt(Integer::intValue).sum();
                if (countMap.get(sum) == null) {
                    countMap.put(sum, 1);
                } else {
                    countMap.put(sum, countMap.get(sum)+1);
                }
            });

            boolean possible = true;

            for (int c = 0; c < n; c++) {
                int sum = 0;
                for (int r = 0; r < n; r++) {
                    sum += matrix.get(r).get(c);
                }

                if (countMap.get(sum) == null) {
                    possible = false;
                    break;
                } else {
                    if (countMap.get(sum) == 1) {
                        countMap.remove(sum);
                    } else {
                        countMap.put(sum, countMap.get(sum)-1);
                    }
                }
            }

            if (possible) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}
