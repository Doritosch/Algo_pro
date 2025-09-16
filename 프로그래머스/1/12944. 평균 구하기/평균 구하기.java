class Solution {
    public double solution(int[] arr) {
        double sum = 0;
        double average = 0;
        for(int i=0; i<arr.length; i++) {
            sum += (double)arr[i];
        }
        average = sum / arr.length;
        return average;
    }
}