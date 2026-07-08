import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int cnt = 0;
        for(int i=x; i<=y; i++) {
            if (isInterest(i)) {
                cnt += 1;
            }
        }
        System.out.print(cnt); 
    }
    private static boolean isInterest(int n) {
        int[] nums = new int[10];

        int cnt = 0;
        while(n > 0) {
            int cur = n % 10;
            nums[cur] += 1;
            n /= 10;
            cnt += 1;
        }

        int k = 0;
        for(int i=0; i<10; i++) {
            if (nums[i] != 0) {
                k += 1;
            }
        }

        if (k != 2) return false;

        for(int i=0; i<10; i++) {
            if (nums[i] == 1) return true;
        }
        return false;
    }
}