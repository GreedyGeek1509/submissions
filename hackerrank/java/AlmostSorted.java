import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class AlmostSorted {

    private static final String YES = "yes";
    private static final String NO  = "no";
    private static final String SWAP = "swap";
    private static final String REVERSE = "reverse";

    private static int ascSort (List<Integer> list, int l, int r) {
        int i;
        for (i=l+1; i<=r && list.get(i) > list.get(i-1); i++);
        return i;
    }

    private static int descSort (List<Integer> list, int l, int r) {
        int i;
        for (i=l+1; i<=r && list.get(i) < list.get(i-1); i++);
        return i;
    }

    private static void isSortable (List<Integer> list) {
        int len = list.size();
        int l = ascSort(list, 0, len-1);
        if (l == len) {
            System.out.println(YES);
            return;
        }

        int r = descSort(list, l-1, len-1);

        if (r == len || (list.get(r) > list.get(l-1) && (l < 2 || list.get(r-1) > list.get(l-2)) && ascSort(list, r, len-1) == len)) {
            System.out.println(YES);
            if (r == l+1) {
                System.out.println(SWAP+" "+l+" "+r);
            } else {
                System.out.println(REVERSE+" "+l+" "+r);
            }
            return;
        }

        r = ascSort(list, l, len-1);
        if (r < len) {
            int tmp = list.get(l-1);
            list.set(l-1, list.get(r));
            list.set(r, tmp);
            if (ascSort(list, 0, len-1) == len) {
                System.out.println(YES);
                System.out.println(SWAP+" "+l+" "+(r+1));
                return;
            }
        }
        System.out.println(NO);
    }

    public static void main (String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        List<Integer> array = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> array.add(reader.nextInt()));
        isSortable(array);
    }
}
