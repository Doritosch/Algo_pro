import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N, M;
    static int[][] map;
    static int maxSafeZone=0;
    private static void buildWall(int checked) {
        if(checked==3) {
            bfs();
            return;
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==0) {
                    map[i][j] = 1;
                    buildWall(checked+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    private static void bfs() {
        Queue<Point> q = new LinkedList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==2) {
                    q.add(new Point(i, j));
                }
            }
        }

        int[][] copyMap = new int[N][M];
        for(int i=0; i<N; i++) {
            copyMap[i] = map[i].clone();
        }

        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(check(nx,ny)&&copyMap[nx][ny]==0) {
                    q.add(new Point(nx, ny));
                    copyMap[nx][ny] = 2;
                }
            }
        }

        countSafeZone(copyMap);
    }

    private static void countSafeZone(int[][] copyMap) {
        int safeZone = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(copyMap[i][j]==0) {
                    safeZone++;
                }
            }
        }

        if(safeZone>maxSafeZone) {
            maxSafeZone = safeZone;
        }
    }

    private static boolean check(int x, int y) {
        return ((x>=0&&x<N)&&(y>=0&&y<M))?true:false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            String[] line= br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        buildWall(0);

        sb.append(maxSafeZone);
        System.out.print(sb.toString());
    }
}