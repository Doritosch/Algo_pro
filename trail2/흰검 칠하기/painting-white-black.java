import java.util.*;

public class Main {
    static int SIZE = 200001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        int[] white = new int[SIZE];
        int[] black = new int[SIZE];
        char[] color = new char[SIZE];

        int idx = 100000;
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);

            if (dir == 'L') {
                for(int j=idx; j>idx-x; j--) {
                    white[j]++;
                    color[j] = 'W';
                }
                idx -= (x-1);
            } else {
                for(int j=idx; j<idx+x; j++) {
                    black[j]++;
                    color[j] = 'B';
                }
                idx += (x-1);
            }
        }

        int w = 0;
        int b = 0;
        int g = 0;
        for(int i=0; i<SIZE; i++) {
            if (white[i] >= 2 && black[i] >= 2) {
                g++;
            } else if (color[i] == 'W') {
                w++;
            } else if (color[i] == 'B') {
                b++;
            }
        }

        System.out.print(w + " " + b + " " + g);
    }
}