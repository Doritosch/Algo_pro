import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static final int MAX_NUM = 40;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        Arrays.sort(arr);
        for(int i=1; i<=MAX_NUM; i++) {
            for(int j=i; j<=MAX_NUM; j++) {
                for(int k=j; k<=MAX_NUM; k++) {
                    for(int l=k; l<=MAX_NUM; l++) {
                        int[] diff = new int[]{i, j, k, l, i+j, j+k, k+l, l+i, i+k, j+l,
                                                i+j+k, i+j+l, i+k+l, j+k+l, i+j+k+l};

                        Arrays.sort(diff);
                        boolean success = true;
                        for(int q=0; q<15; q++) {
                            if (arr[q] != diff[q]) {
                                success = false;
                            }
                        }
                        if (success) {
                            System.out.print(i + " " + j + " " + k + " " + l);
                            return;
                        }
                    }
                }
            }
        }
    }
}