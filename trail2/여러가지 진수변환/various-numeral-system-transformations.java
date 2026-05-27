import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        if (b == 4) {
            System.out.print(getBase(n, b));
        } else if (b == 8) {
            System.out.print(getBase(n, b));
        }
    }
    private static String getBase(int n, int b) {
        List<Integer> list = new ArrayList<>();

        int count = 0;

        while(true) {
            if (n < b) {
                list.add(n);
                break;
            }

            list.add(n%b);
            n /= b;
        }
        
        Collections.reverse(list);
        return list.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(""));
    }
}