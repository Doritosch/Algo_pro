import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int startNum = sc.nextInt(); 

        int[] dx = {0, 0, 1, -1}; // 서 동 남 북
        int[] dy = {-1, 1, 0, 0};
        // 1. 시작 칸 찾기
        int x = 0, y = 0;
        int dir = 0;
        if (startNum <= n) {
            x = 0;
            y = startNum - 1;
            dir = 2;
        } else if (startNum <= 2*n) {
            x = (startNum - 1) % n;
            y = n - 1;
            dir = 0;
        } else if (startNum <= 3*n) {
            x = n - 1;
            y = 3 * n - startNum;
            dir = 3;
        } else if (startNum <= 4*n) {
            x = 4 * n - startNum;
            y = 0;
            dir = 1;
        }

        // 2. 이동
        int count = 0;
        while(isRange(x, y, n)) {
            if (grid[x][y] == '\\') { // 0 - 3, 1 - 2
                dir = 3 - dir;
            } else if (grid[x][y] == '/') { // 0 - 2, 1 - 3
                dir = (dir + 2) % 4;
            }

            x += dx[dir];
            y += dy[dir];

            count += 1;
        }

        System.out.print(count);
    }
    private static boolean isRange(int x, int y, int n) {
        if ((0 <= x && x < n) && (0 <= y && y < n)) {
            return true;
        }
        return false;
    }
}