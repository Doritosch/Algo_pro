import java.util.*;

public class Main {
    private static final int MAX_NUM = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] sum = new int[n-1];
        for(int i=0; i<n-1; i++) {
            sum[i] = sc.nextInt();
        }

        
        int[] arr = new int[n];
        for(int i=1; i<=n; i++) {
            arr[0] = i;

            for(int j=1; j<n; j++) {
                arr[j] = sum[j-1] - arr[j-1];
            }

            boolean success = true;
            boolean[] exist = new boolean[MAX_NUM+1];
            for(int j=0; j<n; j++) {
                if (arr[j] <= 0 || arr[j] > n) {
                    success = false;
                } else {
                    if (exist[arr[j]]) {
                        success = false;
                    }
                    exist[arr[j]] = true;
                }
            }
            
            if (success) {
                for(int j=0; j<n; j++) {
                    System.out.print(arr[j] + " ");
                }
                return;
            }
        }
    }
}