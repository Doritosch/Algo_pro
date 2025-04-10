import java.util.*;
import java.io.*;

public class Main {

    static int[] input;
    static int[] arr;
    static boolean[] visited = new boolean[10001];
    static int n,m;

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
        backTracking(0, 0);
    }

    private static void backTracking(int at, int depth) {
        if ( depth == m ) {
            for(int i=0; i<m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=at; i<n; i++) {
            if ( !visited[input[i]] ) {
                arr[depth] = input[i];
                visited[input[i]] = true;
                backTracking(i+1, depth+1);
                visited[input[i]] = false;
            }
        }
    }
}