import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int ans = 0;
        if (a > d || b < c) {
            ans = b-a + d-c;
        } else {
            ans = Math.max(b,d) - Math.min(a,c);
        }
        System.out.print(ans);
    }
}