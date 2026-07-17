import java.util.*;

public class Main {
    private static final int INT_MIN = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int max1 = arr[0] * arr[1] * arr[n-1];
        int max2 = arr[n-1] * arr[n-2] * arr[n-3];
        int result = Math.max(max1, max2);
        System.out.print(result);
    }
}