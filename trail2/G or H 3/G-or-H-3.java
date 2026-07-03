import java.util.*;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] arr = new char[10001];
        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            arr[num] = sc.next().charAt(0);
        }

        int max = INT_MIN;
        for(int i=1; i<=10000-k; i++) {
            int sum = 0;
            for(int j=i; j<=i+k; j++) {
                if (arr[j] == 'G') {
                    sum += 1;
                } else if (arr[j] == 'H') {
                    sum += 2;
                }
            }
            max = Math.max(max, sum);
        }

        System.out.print(max);
    }
}