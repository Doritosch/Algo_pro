import java.util.*;

public class Main {
    private static int n;
    private static final int INT_MIN = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[][] grid = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int max = INT_MIN;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=n-3; j++) {
                for(int k=i; k<n; k++) {
                    for(int l=0; l<=n-3; l++) {
                        if (i==k && !(j+3 <= l || l+3 <= j)) {
                            continue;
                        }
                        max = Math.max(max, grid[i][j] + grid[i][j+1] + grid[i][j+2]
                                    + grid[k][l] + grid[k][l+1] + grid[k][l+2]);
                    }
                }
            }
        }

        System.out.print(max);
    }
}