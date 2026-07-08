import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        char[] dist = new char[t];
        int[] pos = new int[t];
        for(int i=0; i<t; i++) {
            char c = sc.next().charAt(0);
            int x = sc.nextInt();
            dist[i] = c;
            pos[i] = x;
        }

        int cnt = 0;
        for(int i=a; i<=b; i++) {
            int ms = INT_MAX;
            int mn = INT_MAX;
            for(int j=0; j<t; j++) {
                if (dist[j] == 'S') {
                    ms = Math.min(ms, Math.abs(i - pos[j]));
                } else {
                    mn = Math.min(mn, Math.abs(i - pos[j]));
                }
            }
            if (ms <= mn) {
                cnt += 1;
            }
        }
        System.out.print(cnt);
    }
}