import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            String s = br.readLine();

            StringBuilder stringBuilder = new StringBuilder();
            Stack<Character> pushStack = new Stack<>();
            Stack<Character> deleteStack = new Stack<>();
            for(int j=0; j<s.length(); j++) {
                char ch = s.charAt(j);
                if ( ch == '<' ) {
                    if ( !pushStack.isEmpty() ) {
                        deleteStack.push(pushStack.pop());
                    }
                } else if ( ch == '>' ) {
                    if ( !deleteStack.isEmpty() ) {
                        pushStack.push(deleteStack.pop());
                    }
                } else if ( ch == '-' ) {
                    if ( !pushStack.isEmpty() ) {
                        pushStack.pop();
                    }
                } else {
                    pushStack.push(ch);
                }
            }

            while(!deleteStack.isEmpty()) {
                pushStack.push(deleteStack.pop());
            }

            for(int j=0; j<pushStack.size(); j++) {
                stringBuilder.append(pushStack.get(j));
            }

            System.out.println(stringBuilder.toString());
        }
    }

}