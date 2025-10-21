class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int left = 0;
        for(int i=0; i<targets.length; i++) {
            int sum = 0;
            for(int j=0; j<targets[i].length(); j++) {
                String s = String.valueOf(targets[i].charAt(j));
                int min = 101;
                for(int k=0; k<keymap.length; k++) {
                    int idx = keymap[k].indexOf(s);
                    if (idx != -1) {
                        min = Math.min(min, idx + 1);    
                    }
                }
                if (min == 101) {
                    sum = -1;
                    break;
                } else {
                    sum += min;   
                }
            }
            answer[left++] = sum;
        }
        return answer;
    }
}