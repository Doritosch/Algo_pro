import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int count = 0;
        for(int i=0; i<s.length()-1; i++) {
            char c = s.charAt(i);
            
            if (c == ')') {
                continue;
            }

            for(int j=i+1; j<s.length(); j++) {
                char cl = s.charAt(j);

                if (cl == ')') {
                    count += 1;
                }
            }
        }

        System.out.print(count); 
    }
}