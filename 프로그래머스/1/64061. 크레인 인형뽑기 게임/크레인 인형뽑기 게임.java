import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for(int i=0; i<moves.length; i++) {
            for(int j=0; j<board.length; j++) {
                int value = board[j][moves[i]-1];
                if (value > 0) {
                    if (stack.isEmpty()) {
                        stack.push(value);
                    } else if (value == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(value);
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}