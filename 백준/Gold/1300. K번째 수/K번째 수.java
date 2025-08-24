import java.util.*;
import java.io.*;

/**
 * 1300 K번째 수
 *
 * n(2차원 배열 크기), k(목표 인덱스), start, end 초기화
 *
 * while(start<end) {
 *     mid, cnt 갱신
 *     for(n만큼 반복) {
 *         mid 보다 작은 수 카운트
 *     }
 *     if (cnt<k) start 갱신
 *     else answer 갱신 및 end 갱신
 * }
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int start = 1, end = k;
        int answer = 0;
        while(start<=end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            for(int i=1; i<=n; i++) {
                cnt += Math.min(mid/i, n);
            }

            if (cnt<k) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
