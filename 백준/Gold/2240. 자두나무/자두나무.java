import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] time = new int[t+1];
        int[][] dp = new int[t+1][w+1];
        int answer = 0;

        for(int i=1; i<=t; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=t; i++) {
            int tree = time[i];

            for(int j=0; j<=w; j++) {
                if ( j == 0 ) {
                    if ( tree == 1 ) {
                        dp[i][j] = dp[i-1][j] + 1;
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                    continue;
                }

                if ( j%2 == 0 ) {
                    if ( tree == 1 ) {
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    }
                } else {
                    if ( tree == 1 ) {
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                    }
                }
            }
        }

        for(int i=0; i<=w; i++) {
            answer = Math.max(answer, dp[t][i]);
        }

        System.out.println(answer);
    }
}