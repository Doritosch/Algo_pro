import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] words = br.readLine().split(" ");
        int count = words.length;

        for(int i=0; i<words.length; i++) {
            if(words[i].isEmpty()) count--;
        }

        sb.append(count);
        System.out.print(sb.toString());
    }
}
