class Solution {
    public int solution(int[] array) {
        int[] check = new int[1001];
        int max = 0;
        int count = 0;
        int answer = 0;
        for(int i=0; i<array.length; i++) {
            check[array[i]]++;
        }
        
        for(int i=0; i<check.length; i++) {
            if(max<check[i]) {
                max = check[i];
                answer = i;
                count = 0;
            } 
            else if(max==check[i]) count++;
        }
        System.out.print(max);
        return count>0?-1:answer;
    }
}