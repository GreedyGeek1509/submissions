import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
    private static BigInteger factorial(int N) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= N; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(factorial(N));
    }
}
