import java.util.*;
import java.io.*;

class Solution
{
    static int[][] dp;
    static int[] score;
    static int[] cal;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            dp = new int[n+1][l+1];
            score = new int[n+1];
            cal = new int[n+1];
            
            for(int i=1; i<=n; i++) {
            	st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i=0; i<=n; i++) {
            	for(int j=0; j<=l; j++) {
                	if ( i==0 || j==0 ) {
                    	dp[i][j] = 0;
                    } else {
                    	 if ( j < cal[i] ) {
                    	dp[i][j] = dp[i-1][j];
                        } else {
                            dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cal[i]] + score[i]);
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + dp[n][l]);
		}
	}
}