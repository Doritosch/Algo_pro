import java.util.*;

public class Main {
    private static final int INT_MIN = Integer.MIN_VALUE;
    private static final int MAX_HOUR = 1001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        for(int i=0; i<n; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
        }

        int max = INT_MIN;
        for(int i=0; i<n; i++) {
            int[] hour = new int[MAX_HOUR];
            int count = 0;
            for(int j=0; j<n; j++) {
                if (i==j) {
                    continue;
                }
                
                for(int k=s[j]; k<e[j]; k++) {
                    hour[k] += 1;
                }
            }

            for(int j=0; j<MAX_HOUR; j++) {
                if (hour[j] > 0) {
                    count += 1;
                }
            }

            max = Math.max(max, count);
        }

        System.out.print(max);
    }
}