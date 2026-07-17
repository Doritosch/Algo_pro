import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[] c = new char[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.next().charAt(0);
            s[i] = sc.nextInt();
        }
        // Please write your code here.
        int f = 0;
        int ans = 0;
        int[] score = new int[3];
        for(int i=0; i<n; i++) {
            score[c[i] - 'A'] += s[i];

            int result = getResult(score);
            if (result != f) {
                ans += 1;
                f = result;
            }
        }
        System.out.print(ans);
    }

    private static int getResult(int[] s) {
        int a = s[0], b = s[1], c = s[2];
        if ((a==b) && (b==c)) {
            return 0;
        } else if (Math.max(b,c) < a) {
            return 1;
        } else if (Math.max(a,c) < b) {
            return 2;
        } else if (Math.max(a,b) < c) {
            return 3;
        } else if ((a==b) && (a>c)) {
            return 4;
        } else if ((b==c) && (a<c)) {
            return 5;
        } else if ((a==c) && (a>b)) {
            return 6;
        }
        return -1;
    }
}