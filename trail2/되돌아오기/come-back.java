import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int x = 0, y = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int t = 0;

        for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();

            for(int j=0; j<dist; j++) {
                if (dir == 'N') {
                    y += dy[0];
                } else if (dir == 'E') {
                    x += dx[1];
                } else if (dir == 'S') {
                    y += dy[2];
                } else if (dir == 'W') {
                    x += dx[3];
                }
                t += 1;

                if (x == 0 && y == 0) {
                    System.out.print(t);
                    return;
                }
            }
        }
        System.out.print(-1);
    }
}