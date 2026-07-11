import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        int x = 1;
        while(true) {
            int num = x;
            boolean success = true;
            for(int i=1; i<=n; i++) {
                num *= 2;
                if (a[i-1] > num || num > b[i-1]) {
                    success = false;
                }
            }
            if (success) {
                break;
            }
            x += 1;
        }
        System.out.print(x);
    }
}