import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[200];
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            int x = sc.nextInt() + 100;
            int y = sc.nextInt() + 100;

            for(int j=x; j<y; j++) {
                arr[j]++;
            }
        }

        int max = 0;
        for(int i=0; i<arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.print(max);
    }
}