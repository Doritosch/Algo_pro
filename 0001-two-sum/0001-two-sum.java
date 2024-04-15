import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int value_1;
        int sum = 0;
        int[] answer = new int[2];
        for(int i=0; i<nums.length; i++){
            value_1 = nums[i];
            for(int j=i+1; j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
    
}