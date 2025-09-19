class Solution {
    public int[] solution(int n, int m) {
        return new int[]{getGCD(n,m), getLCM(n,m)};
    }
    public int getGCD(int n, int m) {
        if (m == 0) {
            return n;
        }
        return getGCD(m, n%m);
    }
    public int getLCM(int n, int m) {
        return (n*m) / getGCD(n,m);
    }
}