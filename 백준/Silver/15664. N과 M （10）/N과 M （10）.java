import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int[] input;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        visited = new boolean[n];
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        backTracking(0, 0);
    }
    public static void backTracking(int at, int depth) {
        if ( depth==m ) {
            for(int i=0; i<depth; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        int beforeNum = 0;

        for(int i=at; i<n; i++) {
            if ( !visited[i] ) {
                if ( beforeNum != input[i] ) {
                    visited[i] = true;
                    beforeNum = input[i];
                    arr[depth] = input[i];
                    backTracking(i+1, depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}