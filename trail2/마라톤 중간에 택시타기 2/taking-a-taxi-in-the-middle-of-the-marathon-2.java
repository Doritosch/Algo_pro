import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] pos = new int[n][2];

        for(int i=0; i<n; i++) {
            pos[i][0] = sc.nextInt();
            pos[i][1] = sc.nextInt();
        }

        int min = INT_MAX;
        for(int i=1; i<n-1; i++) {
            int distance = 0;
            int x = pos[0][0];
            int y = pos[0][1];
            for(int j=1; j<n; j++) {
                if (i != j) {
                    distance += Math.abs(x - pos[j][0]) + Math.abs(y - pos[j][1]);

                    x = pos[j][0];
                    y = pos[j][1];
                }
            }
            min = Math.min(min, distance);
        }

        System.out.print(min);
    }
}