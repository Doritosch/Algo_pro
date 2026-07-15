import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] pos = new int[3];
        for(int i=0; i<3; i++) {
            pos[i] = sc.nextInt();
        }

        Arrays.sort(pos);
        int a = pos[0], b = pos[1], c = pos[2];

        int diff1 = Math.abs(a-b);
        int diff2 = Math.abs(b-c);

        int ans = 0;
        if (diff1 == 1 && diff2 == 1) {
            ans = 0;
        } else if (diff1 == 2 || diff2 == 2) {
            ans = 1;
        } else {
            ans = 2;
        }
        System.out.print(ans);
    }
}