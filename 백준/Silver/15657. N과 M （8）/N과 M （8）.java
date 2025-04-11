import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int[] arr;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        backTracking(0, 0);
    }
    public static void backTracking(int at, int depth) {
        if ( depth == m ) {
            for(int i=0; i<depth; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=at; i<n; i++) {
            arr[depth] = nums[i];
            backTracking(i, depth+1);
        }
    }
}