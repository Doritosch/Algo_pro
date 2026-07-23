import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        int even = 0, odd = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
            if (numbers[i]%2 == 0) {
                even += 1;
            } else {
                odd += 1;
            }
        }
        // Please write your code here.
        int group = 0;
        while(true) {
            if (group%2 == 0) {
                if (even > 0) {
                    even -= 1;
                    group += 1;
                } else if (odd >= 2) {
                    odd -= 2;
                    group += 1;
                } else {
                    if (even > 0 || odd > 0) {
                        group -= 1;
                    }
                    break;
                }
            } else {
                if (odd > 0) {
                    odd -= 1;
                    group += 1;
                } else {
                    break;
                }
            }
        }
        System.out.print(group);
    }
}