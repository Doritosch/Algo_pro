import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int avg = 0;
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            avg += arr[i];
        }

        avg /= n;
        int ans = 0;
        for(int i=0; i<n; i++) {
            if (arr[i] < avg) {
                ans += (avg - arr[i]);
            }
        }
        System.out.print(ans);
    }
}