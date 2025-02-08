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

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> keywords = new HashSet<>();

        for(int i=0; i<N; i++) {
            String word = br.readLine();
            keywords.add(word);
        }

        int remainWords = N;
        for(int i=0; i<M; i++) {
            String[] words = br.readLine().split(",");
            for(int j=0; j<words.length; j++) {
                if(keywords.remove(words[j])) {
                    remainWords--;
                }
            }
            sb.append(remainWords).append("\n");
        }
        System.out.print(sb.toString());
    }
}