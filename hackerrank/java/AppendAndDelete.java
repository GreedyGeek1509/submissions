import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/append-and-delete/problem
 */

public class AppendAndDelete {
    private static int numberOfOps (String s1, String s2) {
        int i;
        int minLen = Math.min(s1.length(), s2.length());
        for (i = 0; i < minLen; i++ ) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
        }
        return s1.length() + s2.length() - 2*(i);
    }

    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        int n = scanner.nextInt();
        int nOps = numberOfOps(s1, s2);
        if (n >= (s1.length() + s2.length()) || (n >= nOps && (n - nOps)%2 == 0 )) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}