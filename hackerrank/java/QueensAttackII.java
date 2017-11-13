import java.util.Scanner;
import java.util.function.Function;

/**
* https://www.hackerrank.com/challenges/queens-attack-2/problem
*/

public class QueensAttackII {

    enum Direction {
        LEFT, RIGHT, UP, DOWN,
        RIGHTDUP, RIGHTDDOWN, LEFTDUP, LEFTDDOWN, NONE;

        public static Direction getDirection (int rq, int cq, int ro, int co) {
            if (rq == ro) {
                if (co < cq) {
                    return LEFT;
                } else {
                    return RIGHT;
                }
            } else if ( cq == co) {
                if (ro > rq) {
                    return UP;
                } else {
                    return DOWN;
                }
            } else if (rq - cq == ro - co) {
                if (ro > rq) {
                    return RIGHTDUP;
                } else {
                    return RIGHTDDOWN;
                }
            }else if (rq + cq == ro + co) {
                if (ro > rq) {
                    return LEFTDUP;
                } else {
                    return LEFTDDOWN;
                }
            }
            return NONE;
        }
    }

    private static int n;

    static Function<Integer, Integer> up = r -> n -r;
    static Function<Integer, Integer> down = r -> r - 1;
    static Function<Integer, Integer> left = c -> c - 1;
    static Function<Integer, Integer> right = c -> n - c;

    private static int rightDUp (int r, int c) {
        int diff = r - c;
        return Math.max(0, Math.min(n, n-diff) - c);
    }

    private static int rightDDown (int r, int c) {
        int diff = r - c;
        return Math.max(0, c - Math.max(1, 1 - diff));
    }

    private static int leftDUP (int r, int c) {
        int sum = r + c;
        return Math.max(0, c -Math.max(1, sum - n));
    }

    private static int leftDDown (int r, int c) {
        int sum = r + c;
        return Math.max(0, Math.min(sum - 1, n) - c);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int k = in.nextInt();
        int rQueen = in.nextInt();
        int cQueen = in.nextInt();
        int nAttacks = 0;
        nAttacks += 2*n - 2;
        nAttacks += rightDUp(rQueen, cQueen);
        nAttacks += rightDDown(rQueen, cQueen);
        nAttacks += leftDUP(rQueen, cQueen);
        nAttacks += leftDDown(rQueen, cQueen);

        int upo = 0, downo = 0, righto = 0, lefto = 0,
            rdu = 0, rdd = 0, ldu = 0, ldd = 0;

        for(int a0 = 0; a0 < k; a0++){
            int rObstacle = in.nextInt();
            int cObstacle = in.nextInt();
            Direction direction = Direction.getDirection(rQueen, cQueen, rObstacle, cObstacle);
            switch (direction) {
                case UP:
                    upo = Math.max(upo, up.apply(rObstacle)+1);
                    break;
                case DOWN:
                    downo = Math.max(downo, down.apply(rObstacle)+1);
                    break;
                case LEFT:
                    lefto = Math.max(lefto, left.apply(cObstacle)+1);
                    break;
                case RIGHT:
                    righto = Math.max(righto, right.apply(cObstacle)+1);
                    break;
                case RIGHTDUP:
                    rdu = Math.max(rdu, rightDUp(rObstacle, cObstacle)+1);
                    break;
                case RIGHTDDOWN:
                    rdd = Math.max(rdd, rightDDown(rObstacle, cObstacle)+1);
                    break;
                case LEFTDUP:
                    ldu = Math.max(ldu, leftDUP(rObstacle, cObstacle)+1);
                    break;
                case LEFTDDOWN:
                    ldd = Math.max(ldd, leftDDown(rObstacle, cObstacle)+1);
                    break;
                default:
                    nAttacks += 0;
            }
        }
        nAttacks = nAttacks - (righto + lefto + upo + downo +
                rdu + rdd + ldu + ldd);
        System.out.println(nAttacks);
    }
}
