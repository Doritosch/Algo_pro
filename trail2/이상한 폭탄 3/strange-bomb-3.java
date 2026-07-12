import java.util.Scanner;

public class Main {
    private static final int MAX_NUM = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++)
            bombs[i] = sc.nextInt();
        // Please write your code here.
        int[] nums = new int[MAX_NUM+1];
        for(int i=0; i<n; i++) {
            for(int j=i-k; j<=i+k; j++) {
            if (j<0 || j>=n || j==i) {
                    continue;
                }

                if (bombs[i] == bombs[j]) {
                    nums[bombs[i]] += 1;
                    break;
                }
            }
        }

        int max = 0;
        int ans = 0;
        for(int i=0; i<=MAX_NUM; i++) {
            if (nums[i] > max) {
                max = nums[i];
                ans = i;
            }
        }
        System.out.print(ans);
    }
}