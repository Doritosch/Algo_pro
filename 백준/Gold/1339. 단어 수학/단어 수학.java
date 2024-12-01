import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        int[] weight = new int[26];
        int answer = 0;

        for(int i=0; i<N; i++) {
            String word = br.readLine();
            words[i] = word;
        }

        for(String word: words) {
            int len = word.length();
            for(int i=0; i<len; i++) {
                char c = word.charAt(i);
                weight[c-'A'] += Math.pow(10, len-i-1);
            }
        }

        Arrays.sort(weight);

        int v = 9;
        for(int i=weight.length-1; weight[i]>0; i--) {
            answer += weight[i]*v;
            v--;
        }

        sb.append(answer);
        System.out.print(sb.toString());
    }
}