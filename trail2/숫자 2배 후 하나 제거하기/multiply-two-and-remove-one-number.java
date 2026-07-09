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
        for(int i=0; i<n; i++) {
            arr[i] *= 2;

            for(int j=0; j<n; j++) {
                int[] sub = new int[n-1];
                int cnt = 0;
                for(int k=0; k<n; k++) {
                    if (j == k) {
                        continue;
                    }
                    sub[cnt++] = arr[k];
                }
                int sum = 0;
                for(int k=0; k<n-2; k++) {
                    sum += Math.abs(sub[k+1] - sub[k]);
                }
                ans = Math.min(ans, sum);
            }
            arr[i] /= 2;
        }
        System.out.print(ans);
    }
}