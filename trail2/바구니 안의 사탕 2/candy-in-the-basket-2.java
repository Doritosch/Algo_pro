import java.util.Scanner;
public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] candies = new int[n];
        int[] positions = new int[n];
        int[] arr = new int[101];
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
            positions[i] = sc.nextInt();
            arr[positions[i]] += candies[i];
        }
        // Please write your code here.
        int max = INT_MIN;
        for(int i=0; i<101; i++) {
            int sum = 0;
            for(int j=Math.max(0, i-k); j<=Math.min(100, i+k); j++) {
                sum += arr[j];
            }
            max = Math.max(max, sum);
        }
        System.out.print(max); 
    }
}