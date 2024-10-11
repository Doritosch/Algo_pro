import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Map<String, Double> gradePoints = new HashMap<>();
        gradePoints.put("A+", 4.5);
        gradePoints.put("A0", 4.0);
        gradePoints.put("B+", 3.5);
        gradePoints.put("B0", 3.0);
        gradePoints.put("C+", 2.5);
        gradePoints.put("C0", 2.0);
        gradePoints.put("D+", 1.5);
        gradePoints.put("D0", 1.0);
        gradePoints.put("F", 0.0);

        double totalScore = 0;
        double totalCredit = 0;

        for(int i=0; i<20; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if(grade.equals("P")) {
                continue;
            }

            totalScore += credit * gradePoints.getOrDefault(grade, 0.0);
            totalCredit += credit;
        }

        sb.append(String.format("%.6f", totalScore/totalCredit));
        System.out.print(sb.toString());
    }
}