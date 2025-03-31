import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i=0; i<n; i++) {
            String input =  br.readLine();

            if ( checkNiceWord(input) ) {
                count++;
            }
        }

        System.out.println(count);
    }
    public static boolean checkNiceWord(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if ( stack.isEmpty() ) {
                stack.push(ch);
            } else {
                if ( stack.peek() == ch ) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        if ( stack.isEmpty() ) {
            return true;
        }

        return false;
    }
}