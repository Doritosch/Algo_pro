import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];

        int t = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            t = Math.max(t, nums[i]);
            sum += nums[i];
        }

        // Please write your code here.
        for(int i=t; i<sum; i++) {
            int cnt = 1;
            int s = 0;
            for(int j=0; j<n; j++) {
                s += nums[j];
                if (s > i) {
                    cnt += 1;
                    s = nums[j];
                }
            }
            if (cnt <= m) {
                System.out.print(i);
                return;
            }
        }
    }
}