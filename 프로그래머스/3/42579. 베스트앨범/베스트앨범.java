import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<int[]>> musicMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            musicMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[]{plays[i], i});
        }
        
        List<String> genreList = new ArrayList<>(genreMap.keySet());
        genreList.sort((a,b) -> genreMap.get(b) - genreMap.get(a));
        
        for (String genre : genreList) {
            List<int[]> list = new ArrayList<>(musicMap.get(genre));
            
            list.sort((a,b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return b[0] - a[0];
                }
            });
            
            for(int i=0; i<Math.min(2, list.size()); i++) {
                answer.add(list.get(i)[1]);
            }
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}