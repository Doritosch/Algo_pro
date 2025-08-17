import java.util.*;
import java.io.*;

/**
 * 2023 - 신기한 소수
 *
 * n(자릿수)
 * dfs(숫자, 자릿수) {
 *     if (자릿수 == n) {
 *         if (소수) {
 *             수 출력하기
 *         }
 *         탐색 종료
 *     }
 *
 *  for(1~9 반복) {
 *      if(뒤에 붙는 수가 홀수이면서 소수일 떄) {
 *          dfs(현재수*10 + i, 자릿수 + 1);
 *      }
 *  }
 * }
 *
 * 소수 구하는 함수
 * for(i -> 2~수/2 까지 반복) {
 *     if (수%i == 0) return false;
 * }
 * return true;
 */
class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }
    static void dfs(int num, int depth) {
        if (depth == n) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for(int i=1; i<=9; i++) {
            if (i%2 == 0) {
                continue;
            }
            if (isPrime(num*10+i)) {
                dfs(num*10+i, depth+1);
            }
        }
    }
    static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++) {
            if (num%i == 0) {
                return false;
            }
        }
        return true;
    }
}