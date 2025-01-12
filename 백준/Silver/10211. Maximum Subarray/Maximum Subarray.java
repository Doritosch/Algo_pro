import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    static int N, maxNum = Integer.MIN_VALUE;
    static int[] X;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            maxNum = Integer.MIN_VALUE;

            N = Integer.parseInt(br.readLine());
            X = new int[N+1];
            dp = new int[N+1];
            dp[0] = 0;

            String[] s = br.readLine().split(" ");
            for(int j=1; j<=N; j++) {
                X[j] = Integer.parseInt(s[j-1]);
            }

            maxNum = count(X);

            sb.append(maxNum).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static int count(int[] X) {
        for(int i=1; i<=N; i++) {
            dp[i] = Math.max(X[i] + dp[i-1], X[i]);
            maxNum = Math.max(maxNum, dp[i]);
        }
        return maxNum;
    }
}