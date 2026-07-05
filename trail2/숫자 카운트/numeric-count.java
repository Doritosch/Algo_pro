import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        int count = 0;
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                for(int k=1; k<=9; k++) {
                    if (i==j || j==k || i==k) {
                        continue;
                    }

                    boolean flag = true;
                    for(int l=0; l<n; l++) {
                        int f = 0;
                        int s = 0;

                        int h = a[l] / 100;
                        int t = a[l] / 10 % 10;
                        int o = a[l] % 10;

                        if (i == h) {
                            f += 1;
                        }
                        if (t == j) {
                            f += 1;
                        }
                        if (o == k) {
                            f += 1;
                        }
                        if (i == t || i == o) {
                            s += 1;
                        }
                        if (j == h || j == o) {
                            s += 1;
                        }
                        if (k == h || k == t) {
                            s += 1;
                        }

                        if (f != b[l] || s != c[l]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        count += 1;
                    }
                }
            }
        }

        System.out.print(count);
    }
}