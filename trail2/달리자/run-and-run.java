import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for(int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i=1; i<=n; i++) {
            b[i] = sc.nextInt();
        }

        int cnt = 0;
        int d = 0;
        for(int i=1; i<=n; i++) {
            a[i] = d + a[i];
            cnt += a[i] - b[i];
            d = a[i] - b[i];
        }
        System.out.print(cnt);
    }
}