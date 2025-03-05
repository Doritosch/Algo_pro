import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] firstGiveup = {1, 2, 3, 4, 5};
        int[] secondGiveup = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdGiveup = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answers.length; i++) {
            if (answers[i] == firstGiveup[i%5]) {
                score[0] += 1;
            }
            if (answers[i] == secondGiveup[i%8]) {
                score[1] += 1;
            }
            if (answers[i] == thirdGiveup[i%10]) {
                score[2] += 1;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int max = Math.max(Math.max(score[0], score[1]), score[2]);
        for(int i=0; i<3; i++) {
            if (max == score[i]) {
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}