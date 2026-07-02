import java.util.*;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = INT_MIN;
        for(int i=0; i<n-2; i++) {
            for(int j=i+2; j<n; j++) {
                max = Math.max(max, arr[i] + arr[j]);
            }
        }

        System.out.print(max);
    }
}