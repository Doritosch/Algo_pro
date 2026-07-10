import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] px = new int[n];
        int[] py = new int[n];
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            px[i] = x;
            py[i] = y;
        }

        int ans = 0;
        for(int i=0; i<=10; i++) {
            for(int j=0; j<=10; j++) {
                for(int k=0; k<=10; k++) {
                    boolean success = true;

                    for(int l=0; l<n; l++) {
                        if (px[l] == i || px[l] == j || px[l] == k) {
                            continue;
                        }
                        success = false;
                    }

                    if (success) {
                        ans = 1;
                    }

                    success = true;
                    for(int l=0; l<n; l++) {
                        if (px[l] == i || px[l] == j || py[l] == k) {
                            continue;
                        }
                        success = false;
                    }

                    if (success) {
                        ans = 1;
                    }

                    success = true;
                    for(int l=0; l<n; l++) {
                        if (px[l] == i || py[l] == j || py[l] == k) {
                            continue;
                        }
                        success = false;
                    }

                    if (success) {
                        ans = 1;
                    }

                    success = true;
                    for(int l=0; l<n; l++) {
                        if (py[l] == i || py[l] == j || py[l] == k) {
                            continue;
                        }
                        success = false;
                    }

                    if (success) {
                        ans = 1;
                    }
                }
            }
        }
        System.out.print(ans);
    }
}