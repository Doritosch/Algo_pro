import java.util.Scanner;

public class Main {
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.
        int[][] grid = new int[n][n];

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int dir = 3;

        int x = n/2, y = n/2;
        grid[x][y] = 1;
        for(int i=2; i<=n*n; i++) {
            int ndir = (dir + 1) % 4;
            int nx = x + dx[ndir], ny = y + dy[ndir];

            if (isRange(nx, ny) && grid[nx][ny] == 0) {
                x = nx; 
                y = ny;
                dir = ndir;
            } else {
                x = x + dx[dir];
                y = y + dy[dir];
            }

            grid[x][y] = i;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(grid[i][j]);
                if (j != n-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    private static boolean isRange(int x, int y) {
        if ((0 <= x && x < n) && (0 <= y && y < n)) {
            return true;
        }
        return false;
    }
}