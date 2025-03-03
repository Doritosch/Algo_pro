class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int i=0;
        int j=0;
        for (String s : goal) {
            if (i<cards1.length && cards1[i].equals(s)) {
                i++;
            }
            if (j<cards2.length && cards2[j].equals(s)) {
                j++;
            }
        }
        
        if (i+j == goal.length) {
            return "Yes";
        } else {
            return "No";
        }
    }
}