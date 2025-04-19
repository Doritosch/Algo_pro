import java.util.*;
import java.io.*;

public class Main {

    static int n,s;
    static int result;
    static int[] nums;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, 0);
        
        if ( s==0 ) {
            result--;
        }
        
        System.out.println(result);
    }
    public static void backTracking(int depth, int sum) {
        if ( depth==n ) {
            if ( sum==s ) {
                result++;
            }
            return;
        }

        backTracking(depth+1, sum + nums[depth]);
        backTracking(depth+1, sum);
    }
}