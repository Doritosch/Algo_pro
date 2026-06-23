import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] pos = new int[201][201];

        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int x1 = sc.nextInt() + 100;
            int y1 = sc.nextInt() + 100;
            int x2 = sc.nextInt() + 100;
            int y2 = sc.nextInt() + 100;

            if (i%2==0) {
                for(int j=x1; j<x2; j++) {
                    for(int k=y1; k<y2; k++) {
                        pos[j][k] = 1; // 빨강
                    }
                }
            } else {
                for(int j=x1; j<x2; j++) {
                    for(int k=y1; k<y2; k++) {
                        pos[j][k] = 2; // 파랑
                    }
                }
            }
        }

        int count = 0;
        for(int i=0; i<pos.length; i++) {
            for(int j=0; j<pos[0].length; j++) {
                if (pos[i][j] == 2) {
                    count += 1;
                }
            }
        }

        System.out.print(count);
    }
}