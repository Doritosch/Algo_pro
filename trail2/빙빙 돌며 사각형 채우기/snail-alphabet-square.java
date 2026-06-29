import java.util.Scanner;
public class Main {
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // Please write your code here.
        char[][] grid = new char[n][m];

        int x = 0, y = 0;
        int dir = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        grid[x][y] = 'A';
        for(int i=1; i<n*m; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!isRange(nx, ny) || grid[nx][ny] != 0) {
                dir = (dir + 1) % 4;
            }

            x = x + dx[dir];
            y = y + dy[dir];

            grid[x][y] = (char)('A' + i % 26);
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(grid[i][j]);
                if (j != m-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    private static boolean isRange(int x, int y) {
        if ((0 <= x && x < n) && (0 <= y && y < m)) {
            return true;
        }
        return false;
    }
}