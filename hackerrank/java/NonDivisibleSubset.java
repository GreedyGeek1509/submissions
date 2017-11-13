import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 */

public class NonDivisibleSubset {
    public static void main(String[] args) {
        int n,k;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        List<Integer> moduloCounter = new ArrayList<>(Collections.nCopies(k, 0));
        IntStream.range(0, n).forEach(i -> {
            int x = scanner.nextInt();
            x = x%k;
            moduloCounter.set(x, moduloCounter.get(x)+1);
        });
        int ans = Math.min(1, moduloCounter.get(0));
        for (int i = 1; i < k/2 + k%2; i++) {
            ans += Math.max(moduloCounter.get(i), moduloCounter.get(k-i));
        }
        if (k%2 == 0) {
            ans +=  Math.min(1, moduloCounter.get(k/2));
        }

        System.out.println(ans);
    }
}
