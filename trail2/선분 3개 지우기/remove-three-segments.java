import java.util.*;

class Line {
    int x1, x2;

    public Line(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Line[] line = new Line[n];
        for(int i=0; i<n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            line[i] = new Line(x1, x2);
        }

        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    boolean[] visit = new boolean[101];
                    boolean flag = true;
                    for(int l=0; l<n; l++) {
                        if (l == i || l == j || l == k) {
                            continue;
                        }

                        for(int q=line[l].x1; q<=line[l].x2; q++) {
                            if (visit[q]) {
                                flag = false;
                                break;
                            }
                            visit[q] = true;
                        }
                    }
                    if (flag) {
                        count += 1;
                    }
                }
            }
        }
        System.out.print(count);
    }
}