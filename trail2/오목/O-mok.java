import java.util.*;

public class Main {
    public static int[][] board;
    public static int[] dx = {0, 1, 1, 1};
    public static int[] dy = {1, 0, 1, -1};
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        
        board = new int[19][19];
        int[] spot = new int[2];

        for(int i=0; i<19; i++) {
            for(int j=0; j<19; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if (board[i][j] != 0) {
                    spot = check(i, j, board[i][j]);
                    if (spot[0] != -1) {
                        System.out.println(board[i][j]);
                        System.out.print(spot[0] + " " + spot[1]);
                        return;
                    }
                }
            }
        }
        System.out.print(0);
    }
    private static int[] check(int x, int y, int n) {
        int[] middleSpot = new int[2];

        for(int i=0; i<4; i++) {
            int sx = x, sy = y;
            int count = 1;
            for(int j=0; j<4; j++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];

                if (!isRange(nx, ny) || board[nx][ny] != n) {
                    break;
                }

                sx = nx;
                sy = ny;
                count += 1;

                if (count == 3) {
                    middleSpot[0] = nx + 1;
                    middleSpot[1] = ny + 1;
                }
            }

            if (count == 5) {
                return middleSpot;
            }
        }
        return new int[]{-1, -1};
    }
    private static boolean isRange(int x, int y) {
        if ((0 <= x && x < board.length) && (0 <= y && y < board[0].length)) {
            return true;
        }
        return false;
    }
}