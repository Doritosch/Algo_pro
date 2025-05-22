import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
            
            int[][] field = new int[n][n];
            for(int i=0; i<n; i++) {
            	String[] s = br.readLine().split("");
                for(int j=0; j<n; j++) {
                	field[i][j] = Integer.parseInt(s[j]);
                }
            }
            
            int sum = 0;
            for(int i=0; i<=n/2; i++) {
            	for(int j=n/2-i; j<n/2+i+1; j++) {
                	sum += field[i][j];
                }
            }
            
          	for(int i=0; i<n/2; i++) {
            	for(int j=n/2-i; j<n/2+i+1; j++) {
                	sum += field[n-i-1][j];
                   }
            }
            
            System.out.println("#" + test_case + " " + sum);
		}
	}
}