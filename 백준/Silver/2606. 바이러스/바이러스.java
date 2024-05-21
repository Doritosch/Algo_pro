import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 나머지 합
public class Main {
    static int computer;
    static boolean[] visited;
    static int[][] matrix;
    static int count=0;
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        computer = Integer.parseInt(st.nextToken());
        matrix = new int[computer][computer];
        visited = new boolean[computer];

        st = new StringTokenizer(br.readLine());

        int connection = Integer.parseInt(st.nextToken());

        for(int i=0; i<connection; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[a-1][b-1] = matrix[b-1][a-1] = 1;
        }
        dfs(0);
        sb.append(count-1);
        System.out.print(sb);
    }

    public static void dfs(int start){
        visited[start] = true;
        count++;
        for(int i=0; i<computer; i++){
            if(!visited[i] && matrix[start][i] == 1){
                dfs(i);
            }
        }
    }
    public static void main(String args[]) throws Exception {
        solution();
    }
}