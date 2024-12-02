import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[] dp = new int[k+1];
        Arrays.fill(dp, k+1);
        dp[0] = 0;

        for(int i=0; i<n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }

        for(int i=0; i<n; i++) {
            for(int j=coins[i]; j<=k; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }

        if(dp[k]==k+1) {
            sb.append(-1);
        } else {
            sb.append(dp[k]);
        }

        System.out.print(sb.toString());
    }
}