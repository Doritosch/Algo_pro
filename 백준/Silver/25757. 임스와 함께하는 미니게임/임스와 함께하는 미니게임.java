import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String G = st.nextToken();

        Set<String> names = new HashSet<>();
        for(int i=0; i<N; i++) {
            String name = br.readLine();
            names.add(name);
        }

        sb.append(solve(names, G));
        System.out.print(sb.toString());
    }
    private static int solve(Set<String> names, String G) {
        if(G.equals("Y")) {
            return names.size();
        }
        else if(G.equals("F")) {
            return names.size() / 2;
        } else {
            return names.size() / 3;
        }
    }
}