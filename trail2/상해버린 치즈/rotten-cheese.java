import java.util.Scanner;

class Info1 {
    int p, m, t;

    public Info1(int p, int m, int t) {
        this.p = p;
        this.m = m;
        this.t = t;
    }
}
class Info2 {
    int p, t;

    public Info2(int p, int t) {
        this.p = p;
        this.t = t;
    }
}
public class Main {
    private static final int INT_MIN = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();
        int S = sc.nextInt();
        
        Info1[] info1 = new Info1[D];
        Info2[] info2 = new Info2[S];
        for(int i=0; i<D; i++) {
            int p = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();
            info1[i] = new Info1(p, m, t);
        }
        for(int i=0; i<S; i++) {
            int p = sc.nextInt();
            int t = sc.nextInt();
            info2[i] = new Info2(p, t);
        }

        int max = INT_MIN;
        for(int i=1; i<=M; i++) {
            int[] time = new int[N+1];
            for(int j=0; j<D; j++) {
                if (i != info1[j].m) {
                    continue;
                }

                int person = info1[j].p;
                if (time[person] == 0) {
                    time[person] = info1[j].t;
                } else if (time[person] > info1[j].t) {
                    time[person] = info1[j].t;
                }
            }

            boolean flag = true;
            for(int j=0; j<S; j++) {
                int person = info2[j].p;
                if (time[person] == 0) {
                    flag = false;
                } else if (time[person] >= info2[j].t) {
                    flag = false;
                }
            }

            int pill = 0;
            if (flag) {
                for(int j=1; j<=N; j++) {
                    if (time[j] != 0) {
                        pill += 1;
                    }
                }
            }
            max = Math.max(max, pill);
        }
        System.out.print(max);
    }
}