import java.io.*;
import java.util.*;

class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n+1];
        boolean[][] dp = new boolean[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++) {
            dp[i][i] = true;
        }

        for(int i=1; i<=n-1; i++) {
            if ( nums[i] == nums[i+1] ) {
                dp[i][i+1] = true;
            }
        }

        for(int i=2; i<n; i++) {
            for(int j=1; j<=n-i; j++) {
                if ( nums[j] == nums[j+i] && dp[j+1][j+i-1] ) {
                    dp[j][j+i] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if ( dp[s][e] ) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}