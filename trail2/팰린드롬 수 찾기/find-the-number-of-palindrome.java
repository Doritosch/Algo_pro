import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x =sc.nextInt();
        int y = sc.nextInt();

        int cnt = 0;
        for(int i=x; i<=y; i++) {
            int len = String.valueOf(i).length();
            int num = i;
            int[] arr = new int[len];
            for(int j=0; j<len; j++) {
                arr[j] = num % 10;
                num /= 10;
            }

            boolean palindrome = true;
            for(int j=0; j<len/2; j++) {
                if (arr[j] != arr[len-j-1]) {
                    palindrome = false;
                    break;
                }
            }

            if (palindrome) {
                cnt += 1;
            }
        }
        System.out.print(cnt);
    }
}