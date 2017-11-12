import java.util.Scanner;

public class RepeatedString {
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        int aCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }
        long ans = aCount * (n / s.length());
        for (int i = 0; i < n % s.length(); i++) {
            if (s.charAt(i) == 'a') {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
