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
			String line = br.readLine();
            
            int lp = 0;
            int rp = 0;
            int max = 0;
            for(int i=0; i<line.length(); i++) {
            	char ch = line.charAt(i);
                
                if ( ch == 'L' ) {
                	lp -= 1;
                    rp -= 1;
                } else if ( ch == 'R' ) {
                	lp += 1;
                    rp += 1;
                } else {
                	lp -= 1;
                    rp += 1;
                }
                max = Math.max(max, Math.abs(lp));
                max = Math.max(max, Math.abs(rp));
            }
            System.out.println(max);
		}
	}
}