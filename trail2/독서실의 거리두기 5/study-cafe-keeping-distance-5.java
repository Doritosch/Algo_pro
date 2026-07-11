import java.util.Scanner;
public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seat = sc.next();
        // Please write your code here.
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = seat.charAt(i) - '0';
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            if (arr[i] != 0) {
                continue;
            }
            arr[i] = 1;
            int[] seats = new int[n];
            int seatCnt = 0;
            for(int j=0; j<n; j++) {
                if (arr[j] == 1) {
                    seats[seatCnt++] = j;
                }
            }

            int dis = INT_MAX;
            for(int j=1; j<seatCnt; j++) {
                dis = Math.min(dis, seats[j] - seats[j-1]);
            }
            ans = Math.max(ans, dis);
            arr[i] = 0;
        }
        System.out.print(ans);
    }
}