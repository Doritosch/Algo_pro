import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);

            if ( ch == '(' ) {
                stack.push(ch);
                continue;
            }

            if ( ch == ')' ) {
                stack.pop();

                if ( input.charAt(i-1) == '(' ) {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

}