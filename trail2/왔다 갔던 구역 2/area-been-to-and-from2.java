import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[2001];
        int n = sc.nextInt();
        
        int idx = 1000;
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int dir = sc.next().charAt(0);

            if (dir == 'L') {
                for(int j=idx-1; j>=idx-x; j--) {
                    a[j]++;
                }
                idx -= x;
            } else {
                for(int j=idx; j<idx+x; j++) {
                    a[j]++;
                }
                idx += x;
            }
        }

        int count = 0;
        for(int i=0; i<a.length; i++) {
            if (a[i] >= 2) {
                count++;
            }
        }

        System.out.print(count);
    }
}