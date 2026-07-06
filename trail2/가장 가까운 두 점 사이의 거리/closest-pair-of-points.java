import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        
        for(int i=0; i<n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int min = INT_MAX;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int distance = (int)Math.pow(x[i] - x[j], 2) + (int)Math.pow(y[i] - y[j], 2);

                min = Math.min(min, distance);
            }
        }

        System.out.print(min);
    }
}