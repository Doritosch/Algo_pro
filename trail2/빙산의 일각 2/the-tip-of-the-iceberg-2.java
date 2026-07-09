import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] h = new int[n];
        int m = 0;
        for(int i=0; i<n; i++) {
            h[i] = sc.nextInt();
            m = Math.max(m, h[i]);
        }

        int max = 0;
        for(int i=1; i<m; i++) {
            int cnt = 0;
            for(int j=0; j<n; j++) {
                if (j == 0 && h[j] - i > 0) {
                    cnt += 1;
                    continue;
                }
                if (h[j] - i > 0) {
                    if (h[j-1] - i <= 0) {
                        cnt += 1;
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.print(max);
    }
}