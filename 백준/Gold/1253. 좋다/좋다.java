import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int count = solve(nums);
        sb.append(count);
        System.out.print(sb.toString());
    }
    private static int solve(int[] nums) {
        int N = nums.length;
        int count = 0;

        Arrays.sort(nums);
        
        for(int i=0; i<N; i++) {
            int left = 0;
            int right = N-1;

            while(left<right) {
                if(left==i || right==i) {
                    if(left==i) {
                        left++;
                    } else {
                        right--;
                    }
                } else {
                    int now = nums[left] + nums[right];
                    if(nums[i] == now) {
                        count++;
                        break;
                    }
                    else if(nums[i] < now){
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return count;
    }
}