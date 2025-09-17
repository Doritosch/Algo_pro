class Solution {
    public int solution(int[] numbers) {
        int[] digits = new int[10];
        int sum = 0;
        
        for(int i=0; i<numbers.length; i++) {
            digits[numbers[i]]++;
        }
        
        for(int i=1; i<digits.length; i++) {
            if (digits[i] == 0) {
                sum += i;
            }
        }
        return sum;
    }
}