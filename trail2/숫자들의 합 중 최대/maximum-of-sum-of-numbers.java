import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int max = 0;
        int ans = 0;
        for(int i=x; i<=y; i++) {
            int num = i;
            int sum = 0;
            while(num > 0) {
                int d = num % 10;
                num /= 10;

                sum += d;
            }
            max = Math.max(max, sum);
        }
        System.out.print(max);
    }
}