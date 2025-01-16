import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N, M;
    static int[][] tunnel;
    static boolean[][] visited;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        tunnel = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            tunnel[n][m] = 1;
        }

        int max = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(tunnel[i][j]==1 && !visited[i][j]) {
                    dfs(new Point(i,j));
                    if(max<count) max = count;
                }
                count = 0;
            }
        }

        sb.append(max);
        System.out.print(sb.toString());
    }

    public static void dfs(Point p) {
        visited[p.x][p.y] = true;
        count++;
        for(int i=0; i<4; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];

            if((0<nx && N>=nx)&&(0<ny&&M>=ny)) {
                if(tunnel[nx][ny]==1&&!visited[nx][ny]) {
                    dfs(new Point(nx, ny));
                }
            }
        }
    }
}