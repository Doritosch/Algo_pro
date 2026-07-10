import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        // Please write your code here.
        int ans = 0;
        for(int i=1; i<=n; i++) {
            boolean success = true;
            for(int j=0; j<=n-i; j++) {
                String s = str.substring(j, j+i);
                for(int k=j+1; k<=n-i; k++) {
                    String tmp = str.substring(k, k+i);
                    if (s.equals(tmp)) {
                        success = false;
                        break;
                    }
                }
            }
            if (success) {
                ans = i;
                break;
            }
        }
        System.out.print(ans);
    }
}