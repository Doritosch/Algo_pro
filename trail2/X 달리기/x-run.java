import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        // Please write your code here.
        int dist = 0;
        int time = 0;
        int speed = 0;
        while(dist < x) {
            int diff = x - dist;

            if (diff >= ((speed + 1) * (speed + 2)) / 2 )
                speed++;
            else if (diff < (speed * (speed + 1)) / 2)
                speed--;

            dist += speed;

            time++;
        }
        System.out.println(time);
    }
}