import java.util.Scanner;
public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int min = INT_MAX;
        for(int i=1; i<=n; i++) {
            int distance = 0;
            for(int j=1; j<=n; j++) {
                if (i <= j) {
                    distance += (j-i) * arr[j-1];
                } else {
                    distance += (n-i+j) * arr[j-1];
                }
            }
            min = Math.min(min, distance);
        }

        System.out.print(min);
    }
}