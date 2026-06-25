import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] A = new int[n][2];
        int t = 0;
        for (int i = 0; i < n; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
            t += A[i][1];
        }
        int[][] B = new int[m][2];
        for (int i = 0; i < m; i++) {
            B[i][0] = sc.nextInt();
            B[i][1] = sc.nextInt();
        }
        // Please write your code here.
        int[] aPos = new int[t+1];
        int[] bPos = new int[t+1];

        int at = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<A[i][1]; j++) {
                aPos[at] = A[i][0] + aPos[at-1];
                at += 1;
            }
        }

        int bt = 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<B[i][1]; j++) {
                bPos[bt] = B[i][0] + bPos[bt-1];
                bt += 1;
            }
        }

        int count = 0;
        int lead = -1;
        boolean p = true;
        for(int i=1; i<=t; i++) {
            if (lead == -1) {
                if (aPos[i] > bPos[i]) {
                    p = true;
                    lead = i;
                } else if (aPos[i] < bPos[i]) {
                    p = false;
                    lead = i;
                }
                continue;
            }
            if (p && aPos[i] < bPos[i]) {
                count += 1;
                p = false;
            } else if (!p && aPos[i] > bPos[i]) {
                count += 1;
                p = true;
            }
        }

        System.out.print(count);
    }
}