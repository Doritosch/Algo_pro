import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for(int i=0; i<n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        boolean success = false;
        for(int i=0; i<n; i++) {
            int max = 0;
            int min = 101;
            for(int j=0; j<n; j++) {
                if (i==j) continue;

                max = Math.max(max, x1[j]);
                min = Math.min(min, x2[j]); 
            }
            if (max <= min) {
                success = true;
            }
        }
        if (success) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}