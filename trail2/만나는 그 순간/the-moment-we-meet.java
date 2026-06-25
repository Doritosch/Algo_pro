import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Please write your code here.
        int[] a = new int[1000001];
        int[] b = new int[1000001];

        int at = 0;
        int pos = 0;

        for(int i=0; i<n; i++) {
            char dir = sc.next().charAt(0);
            int c = sc.nextInt();

            int d = (dir == 'L') ? -1 : 1;
            for(int j=0; j<c; j++) {
                pos += d;
                at += 1;
                a[at] = pos;
            }
        }

        pos = 0;
        int bt = 0;
        for(int i=0; i<m; i++) {
            char dir = sc.next().charAt(0);
            int c = sc.nextInt();

            int d = (dir == 'L') ? -1 : 1;
            for(int j=0; j<c; j++) {
                pos += d;
                bt += 1;
                b[bt] = pos;
            }
        }

        int l = Math.min(at, bt);
        for(int i=1; i<=l; i++) {
            if (a[i] == b[i]) {
                System.out.print(i);
                return;
            }
        }
        System.out.print(-1);
    }
}