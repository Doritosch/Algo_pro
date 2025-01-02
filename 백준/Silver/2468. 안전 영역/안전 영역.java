import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int count=0;
    public static void bfs(int x, int y, int h) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            int a = p.x;
            int b = p.y;

            for(int i=0; i<4; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];

                if((nx>=0&&nx<field.length)&&(ny>=0&&ny<field[0].length)) {
                    if(!visited[nx][ny]&&field[nx][ny]>h) {
                        q.add(new Point(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        field = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                field[i][j] = Integer.parseInt(input[j]);
            }
        }

        int maxValue = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(field[i][j]>maxValue) maxValue = field[i][j];
            }
        }

        for(int i=0; i<maxValue; i++) {
            visited = new boolean[N][N];
            count = 0;
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    if(!visited[j][k] && field[j][k]>i) {
                        bfs(j,k,i);
                        count+=1;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        sb.append(answer);
        System.out.print(sb.toString());
    }
}