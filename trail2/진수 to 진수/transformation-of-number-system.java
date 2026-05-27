import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();
        String n = sc.nextLine();

        int decimal = getDecimal(a, n);
        String result = getNBase(b, decimal);

        System.out.print(result);
    }
    private static int getDecimal(int base, String n) {
        int sum = 0;
        for(int i=0; i<n.length(); i++) {
            sum = (sum * base) + Character.getNumericValue(n.charAt(i));
        }
        return sum;
    }
    private static String getNBase(int base, int n) {
        List<Integer> list = new ArrayList<>();

        while(true) {
            if (n < base) {
                list.add(n);
                break;
            }

            list.add(n % base);
            n /= base;
        }

        Collections.reverse(list);
        return list.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(""));
    }
}