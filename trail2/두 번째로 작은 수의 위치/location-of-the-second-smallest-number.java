import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        boolean[] check = new boolean[n];
        for(int i=0; i<2; i++) {
            int min = INT_MAX;
            for(int j=0; j<n; j++) {
                if (!check[j] && arr[j] < min) {
                    min = arr[j];
                }
            }
            
            int count = 0;
            int idx = -1;
            for(int j=0; j<n; j++) {
                if (arr[j] == min) {
                    count += 1;
                    idx = j+1;
                    check[j] = true;
                }
            }

            if (i==1) {
                if (count > 1 || count == 0) {
                    System.out.print(-1);
                } else {
                    System.out.print(idx);
                }
            }
        }
    }
}