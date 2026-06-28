import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // Please write your code here.

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int dir = 0;
        int x = 0;
        int y = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'L') {
                dir = (dir-1) < 0 ? 3 : dir-1;
            } else if (c == 'R') {
                dir = (dir + 1) % 4;
            } else if (c == 'F') {
                x += dx[dir];
                y += dy[dir];
            }
        }

        System.out.print(x + " " + y);
    }
}