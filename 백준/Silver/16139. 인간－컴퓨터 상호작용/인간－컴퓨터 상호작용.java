import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 인간-컴퓨터 상호작용
public class Main {
    static String S;
    static int count = 0;
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        S = br.readLine();

        int q = Integer.parseInt(br.readLine());

        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            char a = (st.nextToken()).charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            System.out.println(cumulative(a, l, r));
            count = 0;
        }
    }
    public static int cumulative(char a, int l, int r){
        for(int i = l; i <= r; i++){
            if(S.charAt(i) == a){
                count++;
            }
        }
        return count;
    }
    public static void main(String args[]) throws Exception {
        solution();
    }
}