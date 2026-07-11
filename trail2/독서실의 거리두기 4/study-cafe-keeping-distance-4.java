import java.util.*;

public class Main {
    private static final int MAX_DIST = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        String str = sc.next();
        for(int i=0; i<n; i++) {
            arr[i] = str.charAt(i) - '0';
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if (arr[i] != 0 || arr[j] != 0) {
                    continue;
                }
                arr[i] = 1;
                arr[j] = 1;

                int[] seat = new int[n];
                int seatCnt = 0;
                for(int k=0; k<n; k++) {
                    if (arr[k] == 1) {
                        seat[seatCnt++] = k;
                    }
                }

                int dist = MAX_DIST;
                for(int k=1; k<seatCnt; k++) {
                    dist = Math.min(dist, seat[k] - seat[k-1]);
                }
                ans = Math.max(ans, dist);
                arr[i] = 0;
                arr[j] = 0;
            }
        }
        System.out.print(ans);
    }
}