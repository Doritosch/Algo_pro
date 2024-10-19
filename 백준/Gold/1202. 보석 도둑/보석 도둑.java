import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 입력 처리
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] jewel = new int[N][2];  // [무게, 가치]
        int[] C = new int[K];  // 가방의 최대 수용량

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());  // 보석 무게
            jewel[i][1] = Integer.parseInt(st.nextToken());  // 보석 가치
        }

        for (int i = 0; i < K; i++) {
            C[i] = Integer.parseInt(br.readLine());  // 가방 수용 무게
        }

        // 보석을 무게 기준으로 오름차순 정렬
        Arrays.sort(jewel, Comparator.comparingInt(a -> a[0]));
        // 가방을 무게 기준으로 오름차순 정렬
        Arrays.sort(C);

        // 우선순위 큐 (최대 힙) : 보석의 가치를 저장하는데 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0;
        int jewelIndex = 0;

        // 각 가방에 대해 처리
        for (int i = 0; i < K; i++) {
            // 가방에 담을 수 있는 모든 보석을 큐에 추가
            while (jewelIndex < N && jewel[jewelIndex][0] <= C[i]) {
                pq.add(jewel[jewelIndex][1]);
                jewelIndex++;
            }

            // 가치가 가장 높은 보석을 선택하여 가방에 넣음
            if (!pq.isEmpty()) {
                answer += pq.poll();  // 가장 높은 가치의 보석 선택
            }
        }

        // 결과 출력
        sb.append(answer);
        System.out.print(sb.toString());
    }
}
