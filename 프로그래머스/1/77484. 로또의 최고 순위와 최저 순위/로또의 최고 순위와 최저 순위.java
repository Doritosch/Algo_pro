class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        boolean[] checked = new boolean[6];
        
        int zero = 0;
        int correct = 0;
        for(int i=0; i<lottos.length; i++) {
            for(int j=0; j<win_nums.length; j++) {
                if (!checked[j] && lottos[i] == win_nums[j]) {
                    correct += 1;
                    checked[j] = true;
                }
            }
            if (lottos[i] == 0) {
                zero += 1;
            }
        }
        
        int max = (correct + zero)>1?7-(correct + zero):6;
        int min = correct>1?7-correct:6;
        return new int[] {max, min};
    }
}