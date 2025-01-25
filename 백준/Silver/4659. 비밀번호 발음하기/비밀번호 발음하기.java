import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String password;
        while(!(password = br.readLine()).equals("end")) {
            if(checkPassword(password)) {
                sb.append("<").append(password).append("> is acceptable.").append("\n");
            }
            else {
                sb.append("<").append(password).append("> is not acceptable.").append("\n");
            }
        }

        System.out.print(sb.toString());
    }
    private static boolean checkPassword(String password) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        boolean hasVowel = false;
        int vCount = 0;
        int cCount = 0;
        for(int i=0; i<password.length(); i++) {
            char currentChar = password.charAt(i);
            boolean isVowel = vowels.contains(currentChar);
            hasVowel |= isVowel;

            if(isVowel) {
                vCount++;
                cCount=0;
            } else {
                cCount++;
                vCount=0;
            }

            if(cCount>=3 || vCount>=3) return false;
            if(i>0&&currentChar==password.charAt(i-1)&&currentChar!='e'&&currentChar!='o') return false;
        }
        return hasVowel;
    }
}