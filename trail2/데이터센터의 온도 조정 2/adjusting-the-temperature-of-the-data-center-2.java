import java.util.Scanner;
public class Main {
    private static int n, c, g, h;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        g = sc.nextInt();
        h = sc.nextInt();

        int max = 0;
        int[] ta = new int[n];
        int[] tb = new int[n];
        for (int i = 0; i < n; i++) {
            ta[i] = sc.nextInt();
            tb[i] = sc.nextInt();
            max = Math.max(max, tb[i]);
        }
        // Please write your code here.
        int ans = 0;
        for(int i=-1; i<=max+1; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                sum += getWork(i, ta[j], tb[j]);
            }
            ans = Math.max(ans, sum);
        }
        System.out.print(ans);
    }
    private static int getWork(int n, int ta, int tb) {
        if (n < ta) {
            return c;
        } else if (n <= tb) {
            return g;
        } else {
            return h;
        }
    }
}