import java.util.*;

public class Main {
    private static final int INT_MIN = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] students = new int[n];
        for(int i=0; i<n; i++) {
            students[i] = sc.nextInt();
        }

        int max = INT_MIN;
        for(int i=0; i<n; i++) {
            int[] tmp = new int[n];
            for(int j=0; j<n; j++) {
                tmp[j] = students[j];
            }
            tmp[i] /= 2;

            Arrays.sort(tmp);
            int sum = 0;
            int count = 0;
            for(int j=0; j<n; j++) {
                if (sum + tmp[j] > b) {
                    break;
                }
                sum += tmp[j];
                count += 1;
            }

            max = Math.max(max, count);
        }
        System.out.print(max);
    }
}