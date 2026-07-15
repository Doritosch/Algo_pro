import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        String str = sc.next();
        for(int i=0; i<n; i++) {
            arr[i] = str.charAt(i) - '0';
        }

        int max = 0;
        int cur = 0;
        int mid = 0;
        for(int i=1; i<n; i++) {
            if (arr[i] == 1) {
                if (max < i - cur) {
                    max = i - cur;
                    mid = (i + cur) / 2;
                }
                cur = i;
            }
        }

        arr[mid] = 1;
        cur = 0;
        max = 1001;
        for(int i=1; i<n; i++) {
            if (arr[i] == 1) {
                if (max > i - cur) {
                    max = i - cur;
                }
                cur = i;
            }
        }
        System.out.print(max);
    }
}