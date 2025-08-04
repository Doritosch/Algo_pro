import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for(int i=0; i<line.length(); i++) {
            char c = line.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();

                if (line.charAt(i-1) == ')') {
                    result += 1;
                } else {
                    result += stack.size();
                }
            }
        }
        System.out.println(result);
    }
}
