import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int diff1 = Math.abs(a-b);
        int diff2 = Math.abs(b-c);
        if (diff1 == 1 && diff2 == 1) {
            System.out.print(0);
            return;
        }

        int ans = Math.max(diff1, diff2);
        System.out.print(ans-1);
    }
}