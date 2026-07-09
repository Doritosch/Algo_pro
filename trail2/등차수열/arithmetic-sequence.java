import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    private static final int INT_MIN = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        int min = INT_MAX;
        int max = INT_MIN;
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int ans = 0;
        for(int i=min+1; i<max; i++) {
            int cnt = 0;
            for(int j=0; j<n; j++) {
                for(int k=j+1;k<n; k++) {
                    if ((arr[k] > i && arr[j] < i) && (Math.abs(arr[k] - i) == Math.abs(arr[j] - i))) {
                        cnt += 1;
                    } 
                    if ((arr[k] < i && arr[j] > i) && (Math.abs(arr[k] - i) == Math.abs(arr[j] - i))) {
                        cnt += 1;
                    } 
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}