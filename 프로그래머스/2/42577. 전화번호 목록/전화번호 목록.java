import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        
        for(String phone : map.keySet()) {
            for(int i=0; i<phone.length(); i++) {
                if (map.containsKey(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}