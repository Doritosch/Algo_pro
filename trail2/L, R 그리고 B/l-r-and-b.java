import java.util.*;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static char[][] grid;
    private static int[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        grid = new char[10][10];
        visited = new int[10][10];
        int[] start = new int[2];
        int[] end = new int[2];
        for(int i=0; i<10; i++) {
            String str = sc.next();
            for(int j=0; j<10; j++) {
                grid[i][j] = str.charAt(j);
                if (grid[i][j] == 'L') {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 'B') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        bfs(start[0], start[1]);
        System.out.print(visited[end[0]][end[1]] - 2);
    }
    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = 1;
        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!isRange(nx, ny)) {
                    continue;
                }
                if (grid[nx][ny] == 'R' || visited[nx][ny] != 0) {
                    continue;
                }
                visited[nx][ny] = visited[cur.x][cur.y] + 1;
                q.add(new Node(nx, ny));
            }
        }
    }
    private static boolean isRange(int x, int y) {
        if ((x >= 0 && y >= 0) && (x < 10 && y < 10)) {
            return true;
        }
        return false;
    }
}