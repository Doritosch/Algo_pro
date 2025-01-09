import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] weight = new int[N+1];
        int[] value = new int[N+1];
        int[] dp = new int[K+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=1; i<=N; i++) {
            for(int j=K; j>=weight[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }

        sb.append(dp[K]);
        System.out.print(sb.toString());
    }
}