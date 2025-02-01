import java.awt.*;
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
        Map<String, Integer> words = new HashMap<>();

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            if(s.length()>=M) {
                words.put(s, words.getOrDefault(s, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(words.keySet());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(Integer.compare(words.get(o1), words.get(o2)) != 0) {
                    return Integer.compare(words.get(o2), words.get(o1));
                }
                if(o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            }
        });

        for(String word: list) {
            sb.append(word).append("\n");
        }
        System.out.print(sb.toString());
    }
}