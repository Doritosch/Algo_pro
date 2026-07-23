import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        // Please write your code here.
        int p1 = Math.min(x1, a1);
        int p2 = Math.min(y1, b1);
        int o1 = Math.max(x2, a2);
        int o2 = Math.max(y2, b2);
        int result = (o1 - p1) * (o2 - p2);
        System.out.print(result);
    }
}