import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    private static final int NUM = 6;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] algorithms = new int[NUM];
        int total = 0;
        for(int i=0; i<NUM; i++) {
            algorithms[i] = sc.nextInt();
            total += algorithms[i];
        }

        int min = INT_MAX;
        for(int i=0; i<NUM-2; i++) {
            for(int j=i+1; j<NUM-1; j++) {
                for(int k=j+1; k<NUM; k++) {
                    int sum = algorithms[i] + algorithms[j] + algorithms[k];
                    int ex = total - sum;
                    min = Math.min(min, Math.abs(ex - sum));
                }
            }
        }

        System.out.print(min);
    }
}