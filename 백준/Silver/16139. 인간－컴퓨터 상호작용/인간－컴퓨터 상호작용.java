import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 인간-컴퓨터 상호작용
public class Main {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();

        int[][] A = new int[target.length() + 1][26];
        for (int i = 1; i < target.length() + 1; i++) {
            char x = target.charAt(i - 1);
            for (int j = 0; j < 26; j++) {
                A[i][j] = A[i - 1][j] + ((x - 'a') == j ? 1 : 0);
            }
        }

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int value = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;
            sb.append(A[end][value] - A[start - 1][value]).append("\n");
        }
        System.out.println(sb);
    }
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        S = br.readLine();
//
//        int q = Integer.parseInt(br.readLine());
//
//        for(int i = 0; i < q; i++){
//            st = new StringTokenizer(br.readLine());
//            char a = (st.nextToken()).charAt(0);
//            int l = Integer.parseInt(st.nextToken());
//            int r = Integer.parseInt(st.nextToken());
//
//            System.out.println(cumulative(a, l, r));
//            count = 0;
//        }
//    }
//    public static int cumulative(char a, int l, int r){
//        for(int i = l; i <= r; i++){
//            if(S.charAt(i) == a){
//                count++;
//            }
//        }
//        return count;
//    }
    public static void main(String args[]) throws Exception {
        solution();
    }
}