import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n+1];
        for(int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }

        int count = 0;
        for(int i=1; i<=n-2; i++) {
            for(int j=i+1; j<=n-1; j++) {
                for(int k=j+1; k<=n; k++) {
                    if (a[i] <= a[j] && a[j] <= a[k]) {
                        count += 1;
                    }
                }
            }
        }

        System.out.print(count);
    }
}