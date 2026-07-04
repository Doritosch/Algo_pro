import java.util.*;

public class Main {
    private static final int MAX_SIZE = 101;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] arr = new char[MAX_SIZE];
        for(int i=0; i<n; i++) {
            int pos = sc.nextInt();
            arr[pos] = sc.next().charAt(0);
        }

        int max = 0;
        int size = 0;
        for(int i=1; i<MAX_SIZE-1; i++) {
            for(int j=i+1; j<MAX_SIZE; j++) {
                if (arr[i] == 0 || arr[j] == 0) {
                    continue;
                }

                int g = 0;
                int h = 0;
                for(int k=i; k<=j; k++) {
                    if (arr[k] == 'G') {
                        g += 1;
                    } else if (arr[k] == 'H') {
                        h += 1;
                    }
                }

                if (g == 0 || h == 0 || g == h) {
                    size = Math.max(size, j-i);
                }
            }
        }

        System.out.print(size);
    }
}