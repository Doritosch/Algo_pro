import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();
        // Please write your code here.
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0;
        int dir = 0;
        int t = 0;

        for(int i=0; i<commands.length(); i++) {
            char c = commands.charAt(i);

            if (c == 'F') {
                x += dx[dir];
                y += dy[dir];
            } else if (c == 'L') {
                dir = (dir + 1) % 4;
            } else if (c == 'R') {
                dir = (dir - 1) < 0 ? 3 : dir - 1;
            }
            t += 1;

            if (x == 0 && y == 0) {
                System.out.print(t);
                return;
            }
        }

        System.out.print(-1);
    }
}