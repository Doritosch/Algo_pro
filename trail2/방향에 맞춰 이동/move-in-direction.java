import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            // Please write your code here.
            if (direction == 'N') {
                y += dy[0]*distance;
            } else if (direction == 'E') {
                x += dx[1]*distance;
            } else if (direction == 'S') {
                y += dy[2]*distance;
            } else if (direction == 'W') {
                x += dx[3]*distance;
            }
        }

        System.out.print(x + " " + y);
    }
}