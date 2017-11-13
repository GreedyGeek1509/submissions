import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/queens-attack-2/problem
 */

public class QueensAttackII2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rQueen = in.nextInt();
        int cQueen = in.nextInt();
        List<List<Boolean>> obstacles = new ArrayList<>();

        IntStream.range(0, n+1).forEach(i -> {
            obstacles.add(new ArrayList<>(Collections.nCopies(n+1, false)));
        });

        for(int a0 = 0; a0 < k; a0++){
            int rObstacle = in.nextInt();
            int cObstacle = in.nextInt();
            obstacles.get(rObstacle).set(cObstacle, true);
        }
        int nAttacks = 0;
        for (int i = rQueen+1; i <= n; i++) {
            if (obstacles.get(i).get(cQueen)) {
                break;
            }
            nAttacks++;
        }
        for (int i = rQueen-1; i > 0; i--) {
            if (obstacles.get(i).get(cQueen)) {
                break;
            }
            nAttacks++;
        }
        for (int j = cQueen+1; j <= n; j++) {
            if (obstacles.get(rQueen).get(j)) {
                break;
            }
            nAttacks++;
        }
        for (int j = cQueen-1; j > 1; j--) {
            if (obstacles.get(rQueen).get(j)) {
                break;
            }
            nAttacks++;
        }
        int diff = rQueen - cQueen;
        for (int i = rQueen+1; i <= n; i++) {
            int j = i - diff;
            if (j < 1 || j > n || obstacles.get(i).get(j)) {
                break;
            }
            nAttacks++;
        }
        for (int i = rQueen-1; i > 0; i--) {
            int j = i - diff;
            if (j < 1 || j > n || obstacles.get(i).get(j)) {
                break;
            }
            nAttacks++;
        }
        int sum = rQueen + cQueen;
        for (int i = rQueen+1; i <= n; i++) {
            int j = sum - i;
            if (j < 1 || j > n || obstacles.get(i).get(j)) {
                break;
            }
            nAttacks++;
        }
        for (int i = rQueen-1; i > 0; i --) {
            int j = sum - i;
            if (j < 1 || j > n || obstacles.get(i).get(j)) {
                break;
            }
            nAttacks++;
        }
        System.out.println(nAttacks);
    }
}
