import java.util.*;
import java.io.*;

/**
 * 10026 - 적록색약
 * n(matrix size), matrix(n by n matrix), visited(방문 유무)
 * for(n만큼 반복) {
 *  for(n만큼 반복) {
 *      matrix에 색 입력
 *  }
 * }
 * for(n만큼 반복) {
 *     for(n만큼 반복) {
 *         if(!visited) {
 *          bfs
 *          적록색맥용 bfs
 *         }
 *     }
 * }
 *
 * bfs(node, 적록생맨 유무)
 */
class Main {
    static int zone = 0, wZone = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static char[][] matrix;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        matrix = new char[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<n; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    bfs(new Node(i,j), matrix[i][j], false);
                    zone += 1;
                }
            }
        }

        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    bfs(new Node(i,j), matrix[i][j], true);
                    wZone += 1;
                }
            }
        }

        System.out.println(zone + " " +  wZone);
    }
    public static void bfs(Node node, char color, boolean weak) {
        Queue<Node> q = new LinkedList<>();

        visited[node.x][node.y] = true;
        q.add(node);
        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if ((nx<0 || ny<0) || (nx>=n || ny>=n)) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (weak) {
                    if (isWeakColor(matrix[cur.x][cur.y], matrix[nx][ny])) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny));
                    }
                } else {
                    if (matrix[nx][ny] == color) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
    }
    public static boolean isWeakColor(char c1, char c2) {
        if (c1 == c2) {
            return true;
        }
        boolean rg1 = (c1 == 'R') || (c1 == 'G');
        boolean rg2 = (c2 == 'R') || (c2 == 'G');
        return rg1 && rg2;
    }
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}