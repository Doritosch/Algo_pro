import java.util.*;

public class Main {
    private static final int MAX_VALUE = Integer.MAX_VALUE;
    private static final int MAX_NUM = 6;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] algo = new int[MAX_NUM];
        int total = 0;
        for(int i=0; i<MAX_NUM; i++) {
            algo[i] = sc.nextInt();
            total += algo[i];
        }
        
        int result = MAX_VALUE;
        for(int i=0; i<MAX_NUM; i++) {
            for(int j=i+1; j<MAX_NUM; j++) {
                for(int k=0; k<MAX_NUM; k++) {
                    for(int l=k+1; l<MAX_NUM; l++) {
                        if (i == k || j == k || j == l || i == l) {
                            continue;
                        }

                        int team1 = algo[i] + algo[j];
                        int team2 = algo[k] + algo[l];
                        int team3 = total - (team1 + team2);
                        int min = Math.min(team1, Math.min(team2, team3));
                        int max = Math.max(team1, Math.max(team2, team3));

                        result = Math.min(result, Math.abs(max - min));
                    }
                }
            }
        }

        System.out.print(result);
    }
}