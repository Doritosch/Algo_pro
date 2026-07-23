import java.util.Scanner;
public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
        }
        // Please write your code here.
        int answer = INT_MAX;
        for(int i=0; i<n; i++) {
            int min = INT_MAX;
            int max = 0;
            for(int j=0; j<n; j++) {
                if (i == j) continue;

                min = Math.min(min, s[j]);
                max = Math.max(max, e[j]);
            }
            answer = Math.min(answer, max - min);
        }
        System.out.print(answer);
    }
}