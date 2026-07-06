import java.util.*;

public class Main {
    private static final int INT_MIN = Integer.MIN_VALUE;
    private static int[] x;
    private static int[] y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        x = new int[n];
        y = new int[n];
        for(int i=0; i<n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int max = INT_MIN;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    if ((x[i] == x[j] || x[i] == x[k] || x[j] == x[k]) &&
                    (y[i] == y[j] || y[i] == y[k] || y[j] == y[k])) {
                        max = Math.max(max, area(i, j, k));
                    }
                }
            }
        }

        System.out.print(max);
    }
    private static int area(int i, int j, int k) {
        return Math.abs((x[i] * y[j] + x[j] * y[k] + x[k] * y[i]) -
        (x[j] * y[i] + x[k] * y[j] + x[i] * y[k]));
    }
}