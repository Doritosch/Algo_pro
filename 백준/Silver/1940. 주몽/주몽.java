import java.io.*;
import java.util.*;

/**
 * 1940 주몽
 *
 * n(재료의 개수), m(필요한 수)
 * for(n만큼 반복) {
 *     재료 저장
 * }
 * 재료 오름차순 정렬
 * while(left<right) {
 *     if ( 재료 합 > m ) right 감소
 *     else if ( 재료 합 < m ) left 증가
 *     else if ( 재료 합 == m ) 경우의 수 증가, left 증가, right 감소
 * }
 */
class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int count = 0;

        int[] materials = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(materials);

        int left = 0, right = n-1;
        while(left < right) {
            int sum = materials[left] + materials[right];
            if ( sum > m ) {
                right -= 1;
            } else if ( sum < m ) {
                left += 1;
            } else if ( sum == m ) {
                count += 1;
                left += 1;
                right -= 1;
            }
        }

        System.out.println(count);
    }
}