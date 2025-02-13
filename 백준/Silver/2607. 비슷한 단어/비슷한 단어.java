import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] words = new int[26];
        String s = br.readLine();

        int result = 0;
        for(int i=0; i<n-1; i++) {
            String word = br.readLine();

            int cnt=0;
            for(int j=0; j<s.length(); j++) {
                words[s.charAt(j)-'A']++;
            }
            for(int j=0; j<word.length(); j++) {
                if(words[word.charAt(j)-'A']>0) {
                    cnt++;
                    words[word.charAt(j)-'A']--;
                }
            }

            if(word.length()==s.length() && (word.length()==cnt || word.length()==cnt+1)) result++;
            else if(word.length()==s.length()-1 && word.length()==cnt) result++;
            else if(word.length()==s.length()+1 && word.length()-1==cnt) result++;
        }

        sb.append(result);
        System.out.print(sb.toString());
    }
}