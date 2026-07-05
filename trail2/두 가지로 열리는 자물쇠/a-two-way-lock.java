import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int c2 = sc.nextInt();
        // Please write your code here.
        int count = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    int r1 = Math.min(Math.abs(i-a), n-Math.abs(i-a));
                    int r2 = Math.min(Math.abs(j-b), n-Math.abs(j-b));
                    int r3 = Math.min(Math.abs(k-c), n-Math.abs(k-c));
                    int q1 = Math.min(Math.abs(i-a2), n-Math.abs(i-a2));
                    int q2 = Math.min(Math.abs(j-b2), n-Math.abs(j-b2));
                    int q3 = Math.min(Math.abs(k-c2), n-Math.abs(k-c2));

                    if ((r1<=2 && r2<=2 && r3<=2) || (q1<=2 && q2<=2 && q3<=2)) {
                        count += 1;
                    }
                }
            }
        }

        System.out.print(count);
    }
}