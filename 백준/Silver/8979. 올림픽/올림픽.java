import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] nations = new int[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nations[i][0] = Integer.parseInt(st.nextToken()); // 국가 번호
            nations[i][1] = Integer.parseInt(st.nextToken()); // 금메달
            nations[i][2] = Integer.parseInt(st.nextToken()); // 은메달
            nations[i][3] = Integer.parseInt(st.nextToken()); // 동메달
        }

        System.out.println(solve(nations, K));
    }

    private static int solve(int[][] nations, int K) {
        // 모든 국가의 은메달, 동메달이 0인 경우
        boolean onlyGold = true;
        for (int[] nation : nations) {
            if (nation[2] != 0 || nation[3] != 0) {
                onlyGold = false;
                break;
            }
        }

        // 금메달만 비교하는 경우 최적화
        if (onlyGold) {
            Arrays.sort(nations, (o1, o2) -> o2[1] - o1[1]);
        } else {
            Arrays.sort(nations, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    if (o1[2] == o2[2]) {
                        return o2[3] - o1[3];
                    }
                    return o2[2] - o1[2];
                }
                return o2[1] - o1[1];
            });
        }

        int rank = 1; // 현재 순위
        for (int i = 0; i < nations.length; i++) {
            // 이전 국가와 점수가 동일하면 순위 유지
            if (i > 0 && nations[i][1] == nations[i - 1][1] &&
                nations[i][2] == nations[i - 1][2] &&
                nations[i][3] == nations[i - 1][3]) {
                // 동일 순위 유지
            } else {
                rank = i + 1; // 새로운 순위
            }

            // K번 국가 순위를 반환
            if (nations[i][0] == K) {
                return rank;
            }
        }

        return -1; // K번 국가가 없는 경우
    }
}
