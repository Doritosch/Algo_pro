import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int count = 0;
        for(int i=0; i<s.length()-3; i++) {
            char op1 = s.charAt(i);
            for(int j=i+1; j<s.length()-2; j++) {
                char op2 = s.charAt(j);
                for(int k=j+1; k<s.length()-1; k++) {
                    char cl1 = s.charAt(k);
                    for(int l=k+1; l<s.length(); l++) {
                        char cl2 = s.charAt(l);

                        if (i+1 == j && k+1 == l) {
                            if ((op1 == '(' && op2 == '(') && (cl1 == ')' && cl2 == ')')) {
                                count += 1;
                            }
                        }
                    }
                }
            }
        }

        System.out.print(count);
    }
}