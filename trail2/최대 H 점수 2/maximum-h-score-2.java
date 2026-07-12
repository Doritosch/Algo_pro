import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        // Please write your code here.
        for(int i=1; i<=100; i++) {
            int cnt = 0;
            int canUp = 0;
            for(int j=0; j<n; j++) {
                if (a[j] >= i) {
                    cnt += 1;
                } else if (i-1 == a[j]) {
                    canUp += 1;
                }
            }

            boolean success = true;
            if (i > cnt) {
                int d = i - cnt;
                if (Math.min(canUp,l) < d) {
                    success = false;
                }
            }
            if (!success) {
                System.out.print(i-1);
                return;
            }
        }
    }
}