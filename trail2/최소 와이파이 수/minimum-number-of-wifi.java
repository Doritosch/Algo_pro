import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int ans = 0;
        int wifi = -1;
        for(int i=0; i<n; i++) {
            if (wifi == -1 && arr[i] == 1) {
                wifi = i+m;
                ans += 1;
                continue;
            }
            if (wifi + m < i && arr[i] == 1) {
                wifi = i+m;
                ans += 1;
            }
        }
        System.out.print(ans);
    }
}