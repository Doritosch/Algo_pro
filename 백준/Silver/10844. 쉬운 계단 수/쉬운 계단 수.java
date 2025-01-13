import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][10];

        for(int i=1; i<10; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++) {
            dp[i][0] = dp[i-1][1] % 1000000000;
            for(int j=1; j<=8; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
            dp[i][9] = dp[i-1][8] % 1000000000;
        }

        int max = 0;
        for(int i=0; i<10; i++) {
            max = (max + dp[N][i]) % 1000000000;
        }

        sb.append(max);
        System.out.print(sb.toString());
    }
}