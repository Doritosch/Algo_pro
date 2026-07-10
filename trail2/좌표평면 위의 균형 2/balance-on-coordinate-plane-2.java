import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    private static final int MAX_POS = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];
        for(int i=0; i<n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int ans = INT_MAX;
        for(int i=0; i<=MAX_POS; i+=2) {
            for(int j=0; j<=MAX_POS; j+=2) {
                int[] pos = new int[4];
                for(int k=0; k<n; k++) {
                    if (x[k] > i && y[k] > j) {
                        pos[0] += 1;
                    } else if (x[k] < i && y[k] > j) {
                        pos[1] += 1;
                    } else if (x[k] < i && y[k] < j) {
                        pos[2] += 1;
                    } else {
                        pos[3] += 1;
                    }
                }
                int result = Math.max(pos[0], Math.max(pos[1], Math.max(pos[2], pos[3])));
                ans = Math.min(ans, result);
            }
        }
        System.out.print(ans);
    }
}