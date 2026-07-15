import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        // Please write your code here.
        int maxWin = 0;

        int win = 0;
        for(int i=0; i<n; i++) {
            if (a[i] == 1 && b[i] == 2) {
                win += 1;
            } else if (a[i] == 2 && b[i] == 3) {
                win += 1;
            } else if (a[i] == 3 && b[i] == 1) {
                win += 1;
            }
        }
        maxWin = Math.max(maxWin, win);

        win = 0;
        for(int i=0; i<n; i++) {
            if (a[i] == 1 && b[i] == 3) {
                win += 1;
            } else if (a[i] == 2 && b[i] == 1) {
                win += 1;
            } else if (a[i] == 3 && b[i] == 2) {
                win += 1;
            }
        }
        maxWin = Math.max(maxWin, win);
        System.out.print(maxWin);
    }
}