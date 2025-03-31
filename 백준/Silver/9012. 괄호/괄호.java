import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String input =  br.readLine();

            if ( checkNiceWord(input) ) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    public static boolean checkNiceWord(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if ( ch == '(' ) {
                stack.push(ch);
            }
            if ( ch == ')' ) {
                if ( stack.isEmpty() ) {
                    return false;
                }
                if ( stack.peek() == '(') {
                    stack.pop();
                }
            }
        }

        if ( stack.isEmpty() ) {
            return true;
        }

        return false;
    }
}