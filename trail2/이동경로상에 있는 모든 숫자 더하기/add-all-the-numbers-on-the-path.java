import java.util.Scanner;

public class Main {
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int t = sc.nextInt();
        String commands = sc.next();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int dir = 0;
        int x = n/2, y = n/2;

        int sum = board[x][y];
        for(int i=0; i<commands.length(); i++) {
            char c = commands.charAt(i);

            if (c == 'F') {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (isRange(nx, ny)) {
                    x = nx;
                    y = ny;
                    sum += board[x][y];
                }    
            } else if (c == 'L') {
                dir = (dir + 1) % 4;
            } else if (c == 'R') {
                dir = (dir - 1 >= 0) ? dir - 1 : 3;
            }
        }

        System.out.print(sum);
    }
    private static boolean isRange(int x, int y) {
        if ((0 <= x && x < n) && (0 <= y && y < n)) {
            return true;
        }
        return false;
    }
}