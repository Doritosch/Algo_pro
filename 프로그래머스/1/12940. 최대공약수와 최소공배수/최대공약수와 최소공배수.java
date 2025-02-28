class Solution {
    private int[] getAnswer(int n, int m) {
        int gcd = 0;
        int lcm = 0;
        for(int i=m; i>0; i--) {
            if(m%i==0 && n%i==0) {
                gcd = i;
                break;
            }
        }
        for(int i=1; i<=n; i++) {
            if((n*i)%m==0) {
                lcm = n*i;
                break;
            }
        }
        return new int[] {gcd, lcm};
    }
    public int[] solution(int n, int m) { 
        int[] answer;
        if(n>m) {
            answer = getAnswer(n,m);
        } else {
            answer = getAnswer(m,n);
        }
        
        return answer;
    }
}