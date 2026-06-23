import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] pos = new int[201][201];

        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            int x = sc.nextInt() + 100;
            int y = sc.nextInt() + 100;

            for(int j=x; j<x+8; j++) {
                for(int k=y; k<y+8; k++) {
                    pos[j][k] += 1;
                }
            }
        }

        int count = 0;
        for(int i=0; i<pos.length; i++) {
            for(int j=0; j<pos[0].length; j++) {
                if (pos[i][j] >= 1) {
                    count += 1;
                }
            }
        }

        System.out.print(count);
    }
}