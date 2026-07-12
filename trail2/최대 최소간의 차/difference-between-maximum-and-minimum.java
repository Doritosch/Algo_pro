import java.util.Scanner;
public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = INT_MAX;
        for(int i=1; i<=10000; i++) {
            int cost = 0;
            for(int j=0; j<n; j++) {
                if (arr[j] >=i && arr[j] <= i+k) {
                    continue;
                }

                if (arr[j] < i ) {
                    cost += Math.abs(i - arr[j]);
                } else if (arr[j] > i+k) {
                    cost += Math.abs(arr[j] - (i+k));
                }
            }
            ans = Math.min(ans, cost);
        }
        System.out.print(ans);
    }
}