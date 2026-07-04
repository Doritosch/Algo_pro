import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();

        int[] high = new int[n];
        for(int i=0; i<n; i++) {
            high[i] = sc.nextInt();
        }

        int min = INT_MAX;
        for(int i=0; i<=n-t; i++) {
            for(int j=i+t; j<=n; j++) {
                int count = 0;
                for(int k=i; k<j; k++) {
                    count += Math.abs(high[k] - h);
                }
                min = Math.min(min, count);
            }
        }

        System.out.print(min);
    }
}