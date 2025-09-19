import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split("");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    answer.add(bfs(new Node(i, j)));
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int v : answer) {
            System.out.println(v);
        }
    }
    public static int bfs(Node n) {
        Queue<Node> q = new LinkedList<>();
        q.add(n);
        visited[n.x][n.y] = true;
        int count = 1;
        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx<0 || ny<0 || (nx>=map.length || ny>=map[0].length)) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    count++;
                    visited[nx][ny] = true;
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