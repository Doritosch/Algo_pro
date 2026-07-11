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

        int ans = 0;
        for(int i=1; i<=10000; i++) {
            int cnt = 0;
            for(int j=0; j<n; j++) {
                if (i >= arr[j] && i <= arr[j] + k) {
                    cnt += 1;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}