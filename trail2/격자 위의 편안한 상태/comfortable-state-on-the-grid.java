import java.util.Scanner;

public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] points = new int[m][2];
        
        for (int i = 0; i < m; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        // Please write your code here.
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] grid = new int[n+1][n+1];

        for(int i=0; i<m; i++) {
            int x = points[i][0];
            int y = points[i][1];
            
            int count = 0;
            grid[x][y] = 1;
            for(int j=0; j<4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (isRange(nx, ny) && grid[nx][ny] == 1) {
                    count += 1;
                }
            }

            if (count == 3) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
    private static boolean isRange(int x, int y) {
        if ((0 < x && x <= n) && (0 < y && y <= n)) {
            return true;
        }
        return false;
    }
}