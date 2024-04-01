import java.util.*;

public class Main {
    static boolean[] V;
    static ArrayList<Integer>[] A;
    static int virus;
    public static void solution() throws Exception {
        var scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        V = new boolean[n+1];
        A = new ArrayList[n+1];

        for(int i = 0; i <= n; i++){
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < c; i++){
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            A[Integer.parseInt(tokens[0])].add(Integer.parseInt(tokens[1]));
            A[Integer.parseInt(tokens[1])].add(Integer.parseInt(tokens[0]));
        }

        DRF(1);
        System.out.print(virus);
    }
    public static void DRF(int start){
        V[start] = true;

        for(int x : A[start]){
            if(!V[x]){
                DRF(x);
                virus++;
            }
        }
    }
    public static void main(String args[]) throws Exception {
        solution();
    }
}