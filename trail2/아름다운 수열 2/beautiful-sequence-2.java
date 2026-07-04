import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++)
            B[i] = sc.nextInt();
        

        if (N < M) {
            System.out.print(0);
            return;
        }

        int count = 0;
        for(int i=0; i<=N-M; i++) {
            boolean[] checks = new boolean[M];
            for(int j=i; j<i+M; j++) {
                for(int k=0; k<M; k++) {
                    if (!checks[k] && A[j] == B[k]) {
                        checks[k] = true;
                        break;
                    }
                }
            }    

            boolean flag = false;
            for(int k=0; k<M; k++) {
                if (!checks[k]) {
                    flag = true;
                }
            }
            if (!flag) {
                count += 1;
            }
        }

        System.out.print(count);
    }
}