import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();
        }
        
        int[][] map = new int[201][201];

        for(int i=0; i<n; i++) {
            for(int j=x1[i]+100; j<x2[i]+100; j++) {
                for(int k=y1[i]+100; k<y2[i]+100; k++) {
                    map[j][k] += 1;
                }
            }
        }

        int count = 0;
        for(int i=0; i<201; i++) {
            for(int j=0; j<201; j++) {
                if (map[i][j] >= 1) {
                    count += 1;
                }
            }
        }

        System.out.print(count);
    }
}