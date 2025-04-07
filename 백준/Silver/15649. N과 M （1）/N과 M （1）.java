import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        arr = new int[m];

        backTracking(m, 0, n);
    }

    public static void backTracking(int depth, int curDepth, int n) {
        if ( curDepth == depth ) {
            for(int i=0; i<depth; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=n; i++) {
            if ( !visited[i] ) {
                arr[curDepth] = i;
                visited[i] = true;
                backTracking(depth, curDepth+1, n);
                visited[i] = false;
            }
        }
    }
}