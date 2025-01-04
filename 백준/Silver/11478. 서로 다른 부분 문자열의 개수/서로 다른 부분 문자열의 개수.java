import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        Set<String> words = new HashSet<>();

        for(int i=0; i<input.length(); i++) {
            for(int j=i+1; j<=input.length(); j++) {
                words.add(input.substring(i,j));
            }
        }

        sb.append(words.size());
        System.out.print(sb.toString());
    }
}