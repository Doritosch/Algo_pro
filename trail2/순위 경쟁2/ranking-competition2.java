import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] p = new char[n];
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.next().charAt(0);
            score[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] s = new int[2];
        int ans = 0;
        int record = 0;
        for(int i=0; i<n; i++) {
            if (score[i] == 0) continue;

            s[p[i] - 'A'] += score[i];

            int state;
            if (s[0]>s[1]) {
                state = 1;
            } else if (s[0]<s[1]) {
                state = 2;
            } else {
                state = 0;
            }

            if (state != record) {
                record = state;
                ans += 1;
            }
        }
        System.out.print(ans);
    }
}