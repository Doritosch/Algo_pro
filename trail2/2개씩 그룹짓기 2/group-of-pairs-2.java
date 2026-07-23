import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        Arrays.sort(arr);
        int min = INT_MAX;
        for(int i=0; i<n; i++) {
            min = Math.min(min, arr[n+i] - arr[i]);
        }
        System.out.print(min);
    }
}