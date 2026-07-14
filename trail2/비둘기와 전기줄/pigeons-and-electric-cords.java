import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] dir = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
            dir[i] = sc.nextInt();
        }

        int[] pigeon = new int[11];
        boolean[] check = new boolean[11];
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if (!check[nums[i]]) {
                check[nums[i]] = true;
                pigeon[nums[i]] = dir[i];
            } else {
                if (pigeon[nums[i]] != dir[i]) {
                    cnt += 1;
                    pigeon[nums[i]] = dir[i];
                }
            }
        }
        System.out.print(cnt);
    }
}