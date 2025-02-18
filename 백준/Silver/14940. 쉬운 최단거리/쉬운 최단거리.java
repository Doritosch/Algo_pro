import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int startX = 0;
        int startY = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }
        map = solve(map, startX, startY);

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    private static int[][] solve(int[][] map, int sx, int sy) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];

        q.add(new Point(sx, sy));
        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;

            if(sx==x && sy==y) {
                map[x][y] = 0;
            }
            for(int i=0; i<4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if((nx>=0 && ny>=0) && (nx<map.length && ny<map[0].length)) {
                    if(!visited[nx][ny] && map[nx][ny]!=0) {
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        map[nx][ny] += map[x][y];
                    }
                }
            }
        }

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(!visited[i][j] && map[i][j]!=0) {
                    map[i][j] = -1;
                }
            }
        }
        return map;
    }
}