import java.util.*;
import java.io.*;

/**
 * 1. k개의 직사각형의 내부 갱신
 * 2. 남은 공간(외부) bfs
 */
public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> answer = new ArrayList<>();
        int count = 0;
        
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 직사각형 내부 표시
            removeSquare(new Node(x1, y1), new Node(x2, y2)); 
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    answer.add(bfs(new Node(i, j)));
                    count++;
                }
            }
        }

        Collections.sort(answer);
        System.out.println(count);
        for(int v : answer) {
            System.out.print(v + " ");
        }
    }
    public static void removeSquare(Node n1, Node n2) {
        for(int i=n1.x; i<n2.x; i++) {
            for(int j=n1.y; j<n2.y; j++) {
                map[i][j] = 1;
            }
        }
    }
    public static int bfs(Node n) {
        Queue<Node> q = new LinkedList<>();
        int count = 1;
        q.add(n);
        visited[n.x][n.y] = true;
        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if ((nx<0 || ny<0) || (nx>=map.length || ny>=map[0].length)) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    count++;
                    q.add(new Node(nx, ny));
                }
            }
        }
        return count;
    }
    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
