import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();

        int decimal = getDecimal(n) * 17;
        String binary = getBinary(decimal); 

        System.out.print(binary);
    }
    private static int getDecimal(String n) {
        int sum = 0;
        for(int i=0; i<n.length(); i++) {
            sum = (sum*2) + Character.getNumericValue(n.charAt(i));
        } 
        return sum;
    }
    private static String getBinary(int n) {
        List<Integer> list = new ArrayList<>();
        
        while(true) {
            if (n<2) {
                list.add(n);
                break;
            }

            list.add(n%2);
            n /= 2;
        }

        Collections.reverse(list);
        return list.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(""));
    }
}