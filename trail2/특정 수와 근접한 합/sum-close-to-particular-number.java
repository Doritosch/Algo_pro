import java.util.*;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = INT_MAX;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int sum = 0;
                for(int k=0; k<n; k++) {
                    if (k != i && k != j) {
                        sum += arr[k];
                    }
                }
                
                min = Math.min(min, Math.abs(sum - s));
            }
        }

        System.out.print(min); 
    }
}