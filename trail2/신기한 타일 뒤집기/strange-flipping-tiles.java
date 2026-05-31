import java.util.*;

public class Main {
    static int SIZE = 200001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] tile = new char[SIZE];
        int n = sc.nextInt();
        int idx = SIZE/2;

        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);

            if (dir == 'L') {
                for(int j=idx; j>idx-x; j--) {
                    tile[j] = 'W';
                }
                idx -= (x-1);
            } else {
                for(int j=idx; j<idx+x; j++) {
                    tile[j] = 'B';
                }
                idx += (x-1);
            }
        }

        int w = 0;
        int b = 0;

        for(int i=0; i<SIZE; i++) {
            if (tile[i] == 'W') {
                w++;
            } else if (tile[i] == 'B') {
                b++;
            }
        }

        System.out.print(w + " " + b);
    }
}