import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = INT_MAX;
        for(int i=0; i<=100; i++) {
            int cost = 0;
            for(int j=0; j<n; j++) {
                if (arr[j] >= i && arr[j] <= i+17) {
                    continue;
                }
                if (i > arr[j]) {
                    cost += (i - arr[j]) * (i - arr[j]);
                } else if (i+17 < arr[j]) {
                    cost += (arr[j] - (i+17)) * (arr[j] - (i+17));
                }
            }
            ans = Math.min(ans, cost);
        }
        System.out.print(ans);
    }
}