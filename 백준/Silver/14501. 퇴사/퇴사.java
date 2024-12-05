import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N][2];
        int[] dp = new int[16];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            schedule[i][0] = T;
            schedule[i][1] = P;
        }

        for(int i=0; i<N; i++) {
            if(i+schedule[i][0] <= N) {
                dp[i+schedule[i][0]] = Math.max(dp[i+schedule[i][0]], dp[i]+schedule[i][1]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        sb.append(dp[N]);
        System.out.print(sb.toString());
    }
}