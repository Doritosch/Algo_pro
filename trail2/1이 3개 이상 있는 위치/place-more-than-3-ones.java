import java.util.Scanner;
public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int result = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int count = 0;
                for (int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (isRange(nx, ny) && arr[nx][ny] == 1) {
                        count += 1;
                    }
                }
                if (count >= 3) {
                    result += 1;
                }
            }
        }

        System.out.print(result);
    }

    private static boolean isRange(int x, int y) {
        if ((0 <= x && x < n) && (0 <= y && y < n)) {
            return true;
        }
        return false;
    }
}