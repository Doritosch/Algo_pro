import java.util.*;
import java.io.*;

public class Main {

    static int[] input;
    static int[] arr;
    static int n,m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        input = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        backTracking(0);
        System.out.print(sb.toString());
    }

    public static void backTracking(int depth) {
        if ( depth == m ) {
            for(int i=0; i<m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++) {
            arr[depth] = input[i];
            backTracking(depth+1);
        }
    }
}