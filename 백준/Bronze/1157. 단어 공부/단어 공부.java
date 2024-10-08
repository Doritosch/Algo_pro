import java.io.*;
import java.nio.Buffer;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabet = new int[26];
        int max = 0;
        char duplicate = '?';
        String text = br.readLine();

        for(int i=0; i<text.length(); i++) {
            char val = Character.toUpperCase(text.charAt(i));
            alphabet[val-'A']++;
            if(alphabet[val-'A'] > max) {
                max = alphabet[val-'A'];
                duplicate = val;
            }
            else if(alphabet[val-'A'] == max) {
                duplicate = '?';
            }
        }
        
        System.out.print(duplicate);

    }
}
