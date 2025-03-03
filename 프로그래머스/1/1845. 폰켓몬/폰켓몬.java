import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        if (nums.length/2 < set.size()) {
            return nums.length/2;
        } else {
            return set.size();
        }
    }
}