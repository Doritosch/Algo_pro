import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[10000001];

        for(int i=2; i<A.length; i++) {
            A[i] = i;
        }
        for(int i=2; i<Math.sqrt(A.length); i++) {
            if (A[i] == 0) {
                continue;
            }
            for(int j = i+i; j<A.length; j += i) {
                A[j] = 0;
            }
        }
        for(int i=n; i<A.length; i++) {
            if (A[i] != 0) {
                if (isPalindrome(A[i])) {
                    System.out.println(A[i]);
                    break;
                }
            }
        }
    }
    private static boolean isPalindrome(int target) {
        char[] charArray = String.valueOf(target).toCharArray();
        int s = 0;
        int e = charArray.length-1;
        while(s<e) {
            if (charArray[s] != charArray[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}