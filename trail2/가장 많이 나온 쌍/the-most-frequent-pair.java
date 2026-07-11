import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[m][2];
        for(int i=0; i<m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        
        int ans = 0;
        for(int i=0; i<m; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            
            int cnt = 1;
            for(int j=0; j<m; j++) {
                if (i == j) {
                    continue;
                }
                if ((a == arr[j][0] && b == arr[j][1]) ||
                b == arr[j][0] && a == arr[j][1]) {
                    cnt += 1;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}