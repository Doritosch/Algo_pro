import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    private static final int INT_MIN = Integer.MIN_VALUE;
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
        for(int i=0; i<n; i++) {
            int minX = INT_MAX, minY = INT_MAX;
            int maxX = INT_MIN, maxY = INT_MIN;
            for(int j=0; j<n; j++) {
                if (i==j) {
                    continue;
                }

                minX = Math.min(minX, x[j]);
                minY = Math.min(minY, y[j]);
                maxX = Math.max(maxX, x[j]);
                maxY = Math.max(maxY, y[j]);
            }
            
            int square = (maxX - minX) * (maxY - minY);
            ans = Math.min(ans, square);
        }

        System.out.print(ans);
    }
}