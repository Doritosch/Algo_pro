import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        String D = sc.next();
        // Please write your code here.
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        int dir = getDirection(D);
        int x = R, y = C;

        for(int i=0; i<T; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (isRange(nx, ny)) {
                x = nx;
                y = ny;
            } else {
                dir = 3 - dir;
            }
        }

        System.out.print(x + " " + y);
    }
    public static boolean isRange(int x, int y) {
        if ((1 <= x && x <= N) && (1 <= y && y <= N)) {
            return true;
        }
        return false;
    }
    public static int getDirection(String s) {
        char c = s.charAt(0);
        if (c == 'L') {
            return 3;
        } else if (c == 'R') {
            return 0;
        } else if (c == 'U') {
            return 2;
        } else if (c == 'D') {
            return 1;
        }
        return -1;
    }
}