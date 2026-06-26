import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] aPos = new int[2000001];
        int[] bPos = new int[2000001];

        int at = 0;
        int pos = 0;
        for(int i=0; i<n; i++) {
            int c = sc.nextInt();
            char dir = sc.next().charAt(0);
            
            int d = (dir == 'L') ? -1 : 1;
            for(int j=at; j<at+c; j++) {
                pos += d;
                aPos[j] = pos;
            }
            at += c;
        }

        int bt = 0;
        pos = 0;
        for(int i=0; i<m; i++) {
            int c = sc.nextInt();
            char dir = sc.next().charAt(0);
            
            int d = (dir == 'L') ? -1 : 1;
            for(int j=bt; j<bt+c; j++) {
                pos += d;
                bPos[j] = pos;
            }
            bt += c;
        }

        int t = Math.max(at, bt);
        for(int i=at; i<t; i++) {
            aPos[i] = aPos[i-1];
        }
        for(int i=bt; i<t; i++) {
            bPos[i] = bPos[i-1];
        }

        int count = 0;
        for(int i=1; i<t; i++) {
            if (aPos[i] == bPos[i] && aPos[i-1] != bPos[i-1]) {
                count += 1;
            }
        }

        System.out.print(count);
    }
}