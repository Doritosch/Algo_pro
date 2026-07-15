import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int dist = Math.abs(a - b);
        dist = Math.min(dist, Math.abs(a-x) + Math.abs(b-y));
        dist = Math.min(dist, Math.abs(a-y) + Math.abs(b-x));
        System.out.print(dist);
    }
}