import java.util.*;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = INT_MIN;
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    if (isCarry(arr[i], arr[j], arr[k])) {
                        max = Math.max(max, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }

        if (max == INT_MIN) {
            System.out.print(-1);
        } else {
            System.out.print(max);
        }
    }
    private static boolean isCarry(int n, int m, int p) {
        while(n>0 || m>0 || p>0) {
            if (n%10 + m%10 + p%10 >= 10) {
                return false;
            }

            n /= 10;
            m /= 10;
            p /= 10;
        }
        return true;
    }
}