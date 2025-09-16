class Solution {
    public double solution(int[] numbers) {
        float sum = 0;
        float average = 0;
        for(int i=0; i<numbers.length; i++) {
            sum += numbers[i];
        }
        
        average = sum / numbers.length;
        return average;
    }
}