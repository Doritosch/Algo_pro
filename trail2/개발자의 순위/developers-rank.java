import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] dev = new int[k][n+1];
        for(int i=0; i<k; i++) {
            for(int j=1; j<=n; j++) {
                int person = sc.nextInt();
                dev[i][person] = j;
            }
        }

        int ans = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if (i == j) {
                    continue;
                }

                boolean higher = true;
                for(int l=0; l<k; l++) {
                    if (dev[l][i] > dev[l][j]) {
                        higher = false;
                    }
                }

                if (higher) {
                    ans += 1;
                }
            }
        }
        System.out.print(ans);
    }
}