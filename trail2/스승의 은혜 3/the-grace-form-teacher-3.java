import java.util.*;

class Cost implements Comparable<Cost> {
    int p, s;

    public Cost(int p, int s) {
        this.p = p;
        this.s = s;
    }

    @Override
    public int compareTo(Cost o) {
        return (this.p + this.s) - (o.p + o.s);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        Cost[] cost = new Cost[n];
        for(int i=0; i<n; i++) {
            int p = sc.nextInt();
            int s = sc.nextInt();
            cost[i] = new Cost(p, s);
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            Cost[] tmp = new Cost[n];
            for(int j=0; j<n; j++) {
                tmp[j] = new Cost(cost[j].p, cost[j].s);
            }
            tmp[i].p /= 2;

            Arrays.sort(tmp);

            int sum = 0;
            int count = 0;
            for(int j=0; j<n; j++) {
                if (sum + tmp[j].p + tmp[j].s > b) {
                    break;
                }

                sum += tmp[j].p + tmp[j].s;
                count += 1;
            }
            max = Math.max(max, count);
        }
        System.out.print(max);
    }
}