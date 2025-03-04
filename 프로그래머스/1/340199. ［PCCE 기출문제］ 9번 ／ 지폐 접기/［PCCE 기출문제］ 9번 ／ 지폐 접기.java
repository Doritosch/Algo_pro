import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int maxWallet = Math.max(wallet[0], wallet[1]);
        int maxBill = Math.max(bill[0], bill[1]);
        int minWallet = Math.min(wallet[0], wallet[1]);
        int minBill = Math.min(bill[0], bill[1]);
        while(minBill>minWallet || maxBill>maxWallet) {
            
            if (bill[0]>bill[1]) {
                bill[0]/=2;
            } else {
                bill[1]/=2;
            }
            answer++;
            
            maxWallet = Math.max(wallet[0], wallet[1]);
            maxBill = Math.max(bill[0], bill[1]);
            minWallet = Math.min(wallet[0], wallet[1]);
            minBill = Math.min(bill[0], bill[1]);
        }
        return answer;
    }
}