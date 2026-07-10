import java.util.*;

public class Main {
    private static Set<String> teamSet;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        teamSet = new HashSet<>();
        int[][] board = new int[3][3];
        for(int i=0; i<3; i++) {
            int n = sc.nextInt();
            for(int j=2; j>=0; j--) {
                board[i][j] = n%10;
                n/=10;
            }
        }

        int ans = 0;
        for(int i=0; i<3; i++) {
            int[] nums = new int[3];
            int cnt = 0;
            for(int j=0; j<3; j++) {
                for(int k=0; k<3; k++) {
                    if (nums[k] == board[i][j]) {
                        break;
                    }
                    if (nums[k] == 0) {
                        nums[k] = board[i][j];
                        cnt += 1;
                        break;
                    }
            
                }
            }
            if (cnt == 2) {
                getTeam(nums);
            }

            nums = new int[3];
            cnt = 0;
            for(int j=0; j<3; j++) {
                for(int k=0; k<3; k++) {
                    if (nums[k] == board[j][i]) {
                        break;
                    }
                    if (nums[k] == 0) {
                        nums[k] = board[j][i];
                        cnt += 1;
                        break;
                    }
                }
            }
            if (cnt == 2) {
                getTeam(nums);
            }
        }
        int[] d = new int[]{board[0][0], board[1][1], board[2][2]};
        int[] nums = new int[3];
        int cnt = 0;
        for(int j=0; j<3; j++) {
            for(int k=0; k<3; k++) {
                if (nums[k] == d[j]) {
                    break;
                }
                if (nums[k] == 0) {
                    nums[k] = d[j];
                    cnt += 1;
                    break;
                }            
            }
        }
        if (cnt == 2) {
            getTeam(nums);
        }
        d = new int[]{board[2][0], board[1][1], board[0][2]};
        nums = new int[3];
        cnt = 0;
        for(int j=0; j<3; j++) {
            for(int k=0; k<3; k++) {
                if (nums[k] == d[j]) {
                    break;
                }
                if (nums[k] == 0) {
                    nums[k] = d[j];
                    cnt += 1;
                    break;
                }            
            }
        }
        if (cnt == 2) {
            getTeam(nums);
        }
        System.out.print(teamSet.size());
    }
    private static void getTeam(int[] nums) {
        int a = 0, b = 0;
        for(int k=0; k<3; k++) {
            if (nums[k] != 0) {
                if (a == 0) {
                    a = nums[k];
                } else {
                    b = nums[k];
                }
            }
        }
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        teamSet.add(min + "-" + max);
    }
}