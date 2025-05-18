import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = Integer.parseInt(br.readLine());
            int[] prices = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
            	prices[i] = Integer.parseInt(st.nextToken());
            }
            
            int max = 0;
            long profit = 0;
            for(int i=n-1; i>=0; i--) {
            	if ( max < prices[i] ) {
                	max = prices[i];
                } else if ( max > prices[i] ) {
                	profit += (max - prices[i]);
                }
               
            }
            System.out.println("#" + test_case + " " + profit);
		}
	}
}