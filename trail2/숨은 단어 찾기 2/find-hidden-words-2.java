import java.util.*;

public class Main {
    private static final int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    private static final int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};
    private static char[][] board;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        board = new char[n][m];
        for(int i=0; i<n; i++) {
            String s = sc.next();
            for(int j=0; j<m; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        
        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (board[i][j] == 'L') {
                    answer += getLee(i, j);
                }
            }
        }
        
        System.out.print(answer);
    }
    private static boolean isRange(int x, int y) {
        if ((0 <= x && x < board.length) && (0 <= y && y < board[0].length)) {
            return true;
        }
        return false;
    }
    private static int getLee(int x, int y) {
        int result = 0;
        for(int i=0; i<8; i++) {
            int sx = x;
            int sy = y;
            int count = 0;
            for(int j=0; j<2; j++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];
                
                if (isRange(nx, ny) && board[nx][ny] == 'E') {
                    count += 1;
                }

                sx = nx;
                sy = ny;
            }
            if (count == 2) {
                result += 1;
            }
        }
        return result;
    }
}