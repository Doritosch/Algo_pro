import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 나머지 합
public class Main {
    static int v;
    static int[][] matrix;
    static boolean[] visited;
    static StringBuilder sb;
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken()); // 사용할때 -1.

        matrix = new int[v+1][v+1];
        visited = new boolean[v+1];

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[a][b] = matrix[b][a] = 1;
        }

        dfs(s);

        visited = new boolean[v+1];

        sb.append("\n");

        bfs(s);

        System.out.print(sb);
    }
    public static void dfs(int start){
        visited[start] = true;
        sb.append(start).append(" ");

        for(int i=0; i<v+1; i++){
            if(!visited[i] && matrix[start][i] == 1){
                dfs(i);
            }
        }
    }
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(start);

        visited[start] = true;

        while(!q.isEmpty()){
            int n = q.poll();
            sb.append(n).append(" ");
            for(int i=1; i<v+1; i++){
                if(!visited[i] && matrix[n][i] == 1){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void main(String args[]) throws Exception {
        solution();
    }
}