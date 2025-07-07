import java.io.*;
import java.util.*;

class Main
{
    static int n, m;
    static int[][] matrix;
    static int[][][] count;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        count = new int[n][m][2];

        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split("");
            for(int j=0; j<m; j++) {
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }

        int answer = bfs(new Node(0, 0, 0));

        System.out.println(answer);
    }
    public static int bfs(Node node) {
        if ( n == 1 && m == 1 ) {
            return 1;
        }
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        count[node.x][node.y][node.w] = 1;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int w = cur.w;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ( (nx>=0 && ny>=0) && (nx<n && ny<m) ) {
                    if ( matrix[nx][ny] == 0 ) {
                        if ( count[nx][ny][w] == 0 ) {
                            q.add(new Node(nx, ny, w));
                            count[nx][ny][w] = count[x][y][w] + 1;
                            if ( nx == n-1 && ny == m-1 ) {
                                return count[nx][ny][w];
                            }
                        }
                    } else {
                        if ( w == 0 ) {
                            if ( count[nx][ny][1] == 0 ) {
                                q.add(new Node(nx, ny, 1));
                                count[nx][ny][1] = count[x][y][w] + 1;
                                if ( nx == n-1 && ny == m-1 ) {
                                    return count[nx][ny][1];
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    public static class Node {
        int x;
        int y;
        int w;
        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
}