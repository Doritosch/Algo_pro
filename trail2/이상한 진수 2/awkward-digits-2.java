import java.util.Scanner;
public class Main {
    private static final int INT_MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        // Please write your code here.
        int max = INT_MIN;
        for(int i=0; i<a.length(); i++) {
            String s = a.substring(0, i) + (char)('1' + '0' - a.charAt(i)) + a.substring(i+1);

            int sum = 0;
            for(int j=0; j<s.length(); j++) {
                if (s.charAt(j) == '1') {
                    sum += Math.pow(2, s.length()-1-j);
                }
            }
            max = Math.max(max, sum);
        }
        System.out.print(max);
    }
}