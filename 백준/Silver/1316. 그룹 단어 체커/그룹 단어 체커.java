import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i=0; i<N; i++) {
            String word = br.readLine();

            if(isGroupWord(word)) {
                count++;
            }
        }
        sb.append(count);
        System.out.print(sb.toString());
    }
    public static boolean isGroupWord(String word) {
        boolean[] used = new boolean[26];
        char prevChar=0;

        for(char c : word.toCharArray()) {
            if(prevChar != c) {
                if(used[c-'a']) {
                    return false;
                }
                used[c-'a'] = true;
            }
            prevChar = c;
        }
        return true;
    }
}