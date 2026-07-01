import java.util.Scanner;
public class Main {
    private static final int INT_MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        // Please write your code here.
        int minDistance = INT_MIN;
        for(int i=0; i<n; i++) {
            int distance = 0;
            for(int j=0; j<n; j++) {
                distance += Math.abs(i-j) * a[j];
            }

            minDistance = Math.min(minDistance, distance);
        }

        System.out.print(minDistance);
    }
}