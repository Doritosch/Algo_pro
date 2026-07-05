import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    private static final int MAX_NUM = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] algo = new int[MAX_NUM];
        int total = 0;
        for(int i=0; i<MAX_NUM; i++) {
            algo[i] = sc.nextInt();
            total += algo[i];
        }

        int result = INT_MAX;
        for(int i=0; i<MAX_NUM; i++) {
            for(int j=i+1; j<MAX_NUM; j++) {
                for(int k=0; k<MAX_NUM; k++) {
                    if (i==k || j==k) {
                        continue;
                    }

                    int team1 = algo[i] + algo[j];
                    int team2 = algo[k];
                    int team3 = total - (team1 + team2);

                    if (team1 == team2 || team2 == team3 || team1 == team3) {
                        continue;
                    }
                    
                    int min = Math.min(team1, Math.min(team2, team3));
                    int max = Math.max(team1, Math.max(team2, team3));
                    result = Math.min(result, max - min);
                }
            }
        }

        if (result == INT_MAX) {
            System.out.print(-1);
        } else {
            System.out.print(result);
        }
    }
}