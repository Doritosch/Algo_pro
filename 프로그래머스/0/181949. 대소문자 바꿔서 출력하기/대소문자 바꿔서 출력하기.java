import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            // 대문자
            if(c < 'Z'){
                answer.append((c+"").toLowerCase());
            }else{
                answer.append((c+"").toUpperCase());
            }
        }
        System.out.println(answer);
    }
}