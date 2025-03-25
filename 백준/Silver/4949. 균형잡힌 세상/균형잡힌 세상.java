import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;
        while(!(s = br.readLine()).equals(".")) {
            if ( check(s) ) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if ( ch == '(' || ch == '[') {
                stack.push(s.charAt(i));
            }

            if ( ch == ')' || ch == ']' ) {
                if ( stack.isEmpty() ) {
                    return false;
                } else {
                    if ( ch == ')' && stack.peek() == '(' ) {
                        stack.pop();
                    } else if ( ch == ']' && stack.peek() == '[' ) {
                        stack.pop();
                    } else if (( ch == ']' && stack.peek() == '(' ) || ( ch == ')' && stack.peek() == '[' )) {
                        return false;
                    }
                }
            }


        }

        if ( stack.isEmpty() ) {
            return true;
        } else {
            return false;
        }
    }
}