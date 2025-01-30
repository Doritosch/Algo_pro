import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] runners = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                runners[j] = Integer.parseInt(st.nextToken());
            }

            sb.append(solve(runners)).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int solve(int[] runners) {
        int[] teams = new int[201]; // 각 팀의 인원 count

        for(int i=1; i<runners.length; i++) {
            teams[runners[i]]++;
        }

        // 팀원이 6명이 안되는 팀 제외
        List<Integer> lastRunners = new ArrayList<>();
        for(int i=1; i<runners.length; i++) {
            if(teams[runners[i]] == 6) {
                lastRunners.add(runners[i]);
            }
        }

        int rank = 1;
        Map<Integer, List<Integer>> teamScore = new HashMap<>();
        for(int runner: lastRunners) {
            teamScore.putIfAbsent(runner, new ArrayList<>());
            teamScore.get(runner).add(rank++);
        }

        int minScore = Integer.MAX_VALUE;
        int minFifthScore = Integer.MAX_VALUE;
        int answer = 0;
        for(int key: teamScore.keySet()) {
            List<Integer> scores = teamScore.get(key);

            int sumScore = scores.get(0) + scores.get(1) + scores.get(2) + scores.get(3);
            int fifthScore = scores.get(4);
            if(sumScore<minScore || (sumScore == minScore && fifthScore < minFifthScore)) {
                minScore = sumScore;
                minFifthScore = fifthScore;
                answer = key;
            }
        }
        return answer;
    }
}