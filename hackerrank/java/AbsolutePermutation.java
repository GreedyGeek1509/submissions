import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/absolute-permutation/problem
 */

public class AbsolutePermutation {

    private static void printPermIter(int n, int K) {
        int add = 2*n*K;
        IntStream.range(1, K+1).forEach(i -> System.out.print(String.valueOf(add+i+K)+" "));
        IntStream.range(K+1, 2*K+1).forEach(i -> System.out.print(String.valueOf(add+i-K)+" "));
    }

    private static void printAbsPerm(int N, int K) {
        if (K == 0) {
            IntStream.range(1, N+1).forEach(i -> System.out.print(i+" "));
            return;
        } else if (N%2 == 1 || K > N/2) {
            System.out.print("-1");
            return;
        } else if (N%(2*K) == 0) {
            IntStream.range(0, N/(2*K)).forEach(n -> printPermIter(n, K));
            return;
        }
        System.out.print("-1");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        IntStream.range(0, T).forEach(t -> {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            printAbsPerm(N, K);
            System.out.println();
        });
    }
}
