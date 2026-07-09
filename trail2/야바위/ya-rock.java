import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] cmd = new int[n][4];
        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            cmd[i][0] = a;
            cmd[i][1] = b;
            cmd[i][2] = c;
        }

        int ans = 0;
        for(int i=1; i<=3; i++) {
            int[] cup = new int[4];
            cup[i] = 1;
            int cnt = 0;
            for(int j=0; j<n; j++) {
                int tmp = cup[cmd[j][0]];
                cup[cmd[j][0]] = cup[cmd[j][1]];
                cup[cmd[j][1]] = tmp;

                if (cup[cmd[j][2]] == 1) {
                    cnt += 1;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}