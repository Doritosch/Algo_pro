class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i=1; i<arr.length; i++){
            int value = answer;
            while(answer%arr[i]!=0){
                answer += value;
            }
        }

        return answer;
    }
}