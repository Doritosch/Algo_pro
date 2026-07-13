import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for(int i=0; i<n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        for(int i=1; i<=100; i++) {
            int cnt = 0;
            for(int j=0; j<n; j++) {
                if (x1[j] <= i && x2[j] >= i) {
                    cnt += 1;
                }
            }
            if (cnt == n) {
                System.out.print("Yes");
                return;
            }
        }
        System.out.print("No");
    }
}