import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int[] input;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        backTracking(0);

        System.out.print(sb.toString());
    }
    public static void backTracking(int depth) {
        if ( depth==m ) {
            for(int i=0; i<depth; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int beforeNum = 0;

        for(int i=0; i<n; i++) {
            if ( beforeNum != input[i] ) {
                beforeNum = input[i];
                arr[depth] = input[i];
                backTracking(depth+1);
            }
        }
    }
}