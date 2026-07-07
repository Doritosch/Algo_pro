import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bomb = new int[n];
        for(int i=0; i<n; i++) {
            bomb[i] = sc.nextInt();
        }

        int max = -1;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if (bomb[i] == bomb[j] && j-i <= k) {
                    max = Math.max(max, bomb[i]);
                }
            }
        }
        System.out.print(max);
    }
}