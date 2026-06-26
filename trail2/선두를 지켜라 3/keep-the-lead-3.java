import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int t = 0;
        int[][] a = new int[n][2];
        int[][] b = new int[m][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            t += a[i][1];
        }
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();
        }
        // Please write your code here.
        int[] aPos = new int[t+1];
        int[] bPos = new int[t+1];

        int at = 0;
        for(int i=0; i<n; i++) {
            int v = a[i][0];
            int c = a[i][1];
            for(int j=at+1; j<=at+c; j++) {
                aPos[j] = aPos[j-1] + v;
            }
            at += c;
        }

        int bt = 0;
        for(int i=0; i<m; i++) {
            int v = b[i][0];
            int c = b[i][1];
            for(int j=bt+1; j<=bt+c; j++) {
                bPos[j] = bPos[j-1] + v;
            }
            bt += c;
        }

        char[] result = new char[t+1];
        for(int i=1; i<=t; i++) {
            if (aPos[i] > bPos[i]) {
                result[i] = 'A';
            } else if (aPos[i] < bPos[i]){
                result[i] = 'B';
            }
        }

        int answer = 0;
        for(int i=1; i<=t; i++) {
            if (result[i] != result[i-1]) {
                answer += 1;
            }
        }
        
        System.out.print(answer);
    }
}