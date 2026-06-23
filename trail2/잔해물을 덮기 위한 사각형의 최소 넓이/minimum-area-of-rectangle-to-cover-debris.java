import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] pos = new int[2001][2001];

        for(int i=0; i<2; i++) {
            int x1 = sc.nextInt() + 1000;
            int y1 = sc.nextInt() + 1000;
            int x2 = sc.nextInt() + 1000;
            int y2 = sc.nextInt() + 1000;

            if (i != 1) {
                for(int j=x1; j<x2; j++) {
                    for(int k=y1; k<y2; k++) {
                        pos[j][k] = 1;
                    }
                }    
            } else {
                for(int j=x1; j<x2; j++) {
                    for(int k=y1; k<y2; k++) {
                        pos[j][k] = 0;
                    }
                }
            }
        }

        int minX = 2001;
        int minY = 2001;
        int maxX = 0;
        int maxY = 0;
        for(int i=0; i<pos.length; i++) {
            for(int j=0; j<pos[0].length; j++) {
                if (pos[i][j] == 1) {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        if (maxX == 0 && minX == 2001) {
            System.out.print(0);
            return;
        }
        
        int answer = (maxX - minX + 1) * (maxY - minY + 1);

        System.out.print(answer);
    }
}