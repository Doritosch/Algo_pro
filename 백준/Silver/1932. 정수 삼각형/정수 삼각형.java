import java.awt.*;
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] numbers = br.readLine().split(" ");
            for(int j=0; j<numbers.length; j++) {
                triangle[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        dp[0][0] = triangle[0][0];
        for(int i=1; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(j==0 || j==i+1) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1]+triangle[i][j], dp[i-1][j]+triangle[i][j]);
                }
            }
        }

        int maxValue = 0;
        for(int i=0; i<n; i++) {
            maxValue = Math.max(maxValue, dp[n-1][i]);
        }

        sb.append(maxValue);
        System.out.print(sb.toString());
    }
}