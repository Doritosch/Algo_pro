import java.util.*;

// 로봇청소기
public class Main {
    static int N, M, r, c;
    static int d; // 0 : 북, 1 : 동, 2 : 남, 3 : 서
    static int count=1;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void solution() throws Exception {
        var scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        r = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = scanner.nextInt();
            }
        }

        DFS(r,c,d);
        System.out.print(count);
    }
    public static void DFS(int x, int y, int d){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            d = (d+3)%4;
            int nx = dx[d] + x;
            int ny = dy[d] + y;

            if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                if(map[nx][ny] == 0 && !visited[nx][ny]){
                    count++;
                    DFS(nx, ny, d);
                    return;
                }
            }
        }

        int bd = (d+2)%4;
        int bx = dx[bd] + x;
        int by = dy[bd] + y;
        if(bx >= 0 && by >= 0 && bx < N && by < M){
            if(map[bx][by] == 0){
                DFS(bx, by, d);
            }
        }

    }
    public static void main(String args[]) throws Exception {
        solution();
    }
}