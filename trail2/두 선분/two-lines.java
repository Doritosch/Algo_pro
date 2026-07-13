import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int x3 = sc.nextInt();
        int x4 = sc.nextInt();

        if (x2 < x3 || x1 > x4) {
            System.out.print("nonintersecting");
        } else {
            System.out.print("intersecting");
        }
    }
}