import java.util.*;
import java.io.*;

/**
 * 11047 동전0
 *
 * n(동전 종류), k(목표 값), A(동전 종류를 받는 1차원 배열), cost(동전의 합), count(동전 개수)
 *
 * for(0~n까지 반복) {
 *     A에 동전 종류 저장하기
 * }
 *
 * A 내림차순 정렬
 * for(i -> 0~n까지 반복) {
 *     if (A[i]<k-cost) 동전 개수와 동전의 합 갱신
 *     if (k-cost == 0) break
 * }
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] A = new Integer[n];

        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A, Collections.reverseOrder());
        int count = 0;
        for(int i=0; i<n; i++) {
            if (k-A[i] >= 0) {
                count += (k / A[i]);
                k -= A[i]*(k / A[i]);
            }
            if (k <= 0) break;
        }

        System.out.println(count);
    }
}