import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean isPalindrome = true;

        String text = br.readLine();

        for(int i=0; i<text.length()/2; i++) {
            if(text.charAt(i)!=text.charAt(text.length()-i-1)) {
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome) {
            sb.append(1);
        } else {
            sb.append(0);
        }
        
        System.out.print(sb.toString());
    }
}
