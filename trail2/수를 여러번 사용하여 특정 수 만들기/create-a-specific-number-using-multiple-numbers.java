import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int ans = 0;
        for(int i=0; i<=c; i+=b) {
            int num = i;
            while(num + a <= c) {
                num += a;
            }
            ans = Math.max(ans, num);
        }
        System.out.print(ans);
    }
}