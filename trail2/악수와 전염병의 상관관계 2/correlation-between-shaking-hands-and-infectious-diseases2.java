import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        int T = sc.nextInt();
        int[][] shakes = new int[T][3];
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt();
            shakes[i][1] = sc.nextInt();
            shakes[i][2] = sc.nextInt();
        }
        // Please write your code here.
        //1. shakes[i][0] 기준으로 오름차순 정렬
        //2. developers[N] <- value에는 바이러스를 옮긴 횟수, virus[N] <- 바이러스에 걸렸는지 확인
        int[] developers = new int[N+1];
        boolean[] virus = new boolean[N+1];
        virus[P] = true;
        Arrays.sort(shakes, (a,b) -> a[0] - b[0]);

        for(int i=0; i<T; i++) {
            int d1 = shakes[i][1];
            int d2 = shakes[i][2];
            
            if (virus[d1] && virus[d2]) {
                if (developers[d1] < K) {
                    developers[d1] += 1;
                }
                if (developers[d2] < K) {
                    developers[d2] += 1;
                }
            } else if (virus[d1] && developers[d1] < K) {
                virus[d2] = true;
                developers[d1] += 1;
            } else if (virus[d2] && developers[d2] < K) {
                virus[d1] = true;
                developers[d2] += 1;
            }
        }

        for(int i=1; i<=N; i++) {
            int result = (virus[i] ? 1 : 0);
            System.out.print(result);
        }
    }
}