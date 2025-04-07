import java.util.*;
import java.io.*;

public class Main {

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

        backTracking(1, 0);

        System.out.println(sb.toString());
    }
    public static void backTracking(int at, int depth) {
        if ( depth == m ) {
            for(int i=0; i<m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=at; i<=n; i++) {
            arr[depth] = i;
            backTracking(i, depth+1);
        }
    }
}