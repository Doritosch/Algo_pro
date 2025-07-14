import java.io.*;
import java.util.*;

/**
 * 2018 수들의 합 5
 *
 * n(변수 저장)
 * 사용할 변수(count(개수), left(좌), right(우), sum(합))
 * while(right가 n이 아닐때까지) {
 *     if ( sum > n ) sum -= left, left 증가
 *     else if ( sum < n ) right 증가, sum += right
 *     else if ( sum == n ) count, right 증가, sum += right
 * }
 */
class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int left = 1, right = 1;
        int sum = 1;

        while(right != n) {
            if ( sum == n ) {
                right += 1;
                sum += right;
                count += 1;
            } else if ( sum > n ) {
                sum -= left;
                left += 1;
            } else if ( sum < n ) {
                right += 1;
                sum += right;
            }
        }

        System.out.println(count);
    }
}