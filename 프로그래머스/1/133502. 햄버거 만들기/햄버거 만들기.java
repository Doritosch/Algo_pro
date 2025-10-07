import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i=0; i<ingredient.length; i++) {
            list.add(ingredient[i]);
            
            int len = list.size();
            if (len >= 4) {
                if (list.get(len-1) == 1 &&
                   list.get(len-2) == 3 &&
                   list.get(len-3) == 2 &&
                   list.get(len-4) == 1) {
                    for(int j=0; j<4; j++) {
                        list.remove(list.size()-1);
                    }
                    count += 1;
                }
                
            }
        }
        return count;
    }
}