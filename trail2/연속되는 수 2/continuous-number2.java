import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        int cnt = 0;
        int max = 0;
        for(int i=0; i<n; i++) {
            if (i==0) {
                cnt = 1;
            } else {
                if (arr[i] == arr[i-1]) {
                    cnt += 1;
                } else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
        }

        max = Math.max(max, cnt);
        System.out.print(max);
    }
}