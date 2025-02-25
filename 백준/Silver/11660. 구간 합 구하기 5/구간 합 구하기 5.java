import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(i==0 && j==0) {
                    dp[i][j] = graph[i][j];
                }
                else if(i==0) {
                    dp[i][j] = graph[i][j] + dp[i][j-1];
                }
                else if(j==0) {
                    dp[i][j] = graph[i][j] + dp[i-1][j];
                } else {
                    dp[i][j] = graph[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
                }
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(solve(dp, x1, y1, x2, y2)).append("\n");
        }

        System.out.print(sb.toString());
    }
    public static int solve(int[][] dp, int x1, int y1, int x2, int y2) {
        return dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
    }
}