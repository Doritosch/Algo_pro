import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] students = new int[31];
        for(int i=0; i<28; i++) {
            st = new StringTokenizer(br.readLine());
            students[Integer.parseInt(st.nextToken())]++;
        }
        for(int i=1; i<31; i++) {
            if(students[i]==0) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
