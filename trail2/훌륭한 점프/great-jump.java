import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 101;
        for(int i=Math.max(arr[0], arr[n-1]); i<=100; i++) {
            int dis = 0;
            int[] availableIndices = new int[n];
            int cnt = 0;
            for(int j=0; j<n; j++) {
                if (arr[j] <= i) {
                    availableIndices[cnt++] = j;
                }
            }

            boolean success = true;
            for(int j=1; j<cnt; j++) {
                if (availableIndices[j] - availableIndices[j-1] > k) {
                    success = false;
                }
            }

            if (success) {
                ans = i;
                break;
            }
        }
        System.out.print(ans);
    }
}