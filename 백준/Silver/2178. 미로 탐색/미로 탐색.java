import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Point{
    int xPoint;
    int yPoint;
    public Point(int xPoint, int yPoint){
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }
}
public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;
    static int[][] matrix;
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int high = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        matrix = new int[high+1][width+1];
        visited = new boolean[high+1][width+1];

        for(int i=0; i<high; i++){
            String line = br.readLine();
            for(int j=0; j<width; j++){
                matrix[i+1][j+1] = Character.getNumericValue(line.charAt(j));
            }
        }

        bfs(1,1);
        sb.append(matrix[high][width]);
        System.out.print(sb);
    }

    public static void bfs(int x, int y){
        visited[x][y] = true;

        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(x,y));
        while(!q.isEmpty()){
            Point nextPoint = q.poll();

            for(int i=0; i<4; i++){
                int nx = nextPoint.xPoint + dx[i];
                int ny = nextPoint.yPoint + dy[i];

                if((nx>0 && ny>0) && (nx<matrix.length && ny<matrix[0].length)){
                    if(!visited[nx][ny] && matrix[nx][ny]==1){
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny));
                        matrix[nx][ny] += matrix[nextPoint.xPoint][nextPoint.yPoint];
                    }
                }
            }
        }

    }
    public static void main(String args[]) throws Exception {
        solution();
    }
}