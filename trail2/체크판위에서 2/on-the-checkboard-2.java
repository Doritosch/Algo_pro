import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] grid = new char[r][c];

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        int count = 0;
        for(int i=1; i<r; i++) {
            for(int j=1; j<c; j++) {
                for(int k=i+1; k<r-1; k++) {
                    for(int l=j+1; l<c-1; l++) {
                        if (grid[0][0] != grid[i][j] &&
                        grid[i][j] != grid[k][l] &&
                        grid[k][l] != grid[r-1][c-1]) {
                            count += 1;
                        }
                    }
                }
            }
        }
        System.out.print(count);
    }
}