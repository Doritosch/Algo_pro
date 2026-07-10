import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        for(int i=1; i<=n; i++) {
            int pos = i;
            int sum = 0;
            for(int j=0; j<m; j++) {
                sum += arr[pos];
                pos = arr[pos];
            }
            max = Math.max(max, sum);
        }
        System.out.print(max);
    }
}