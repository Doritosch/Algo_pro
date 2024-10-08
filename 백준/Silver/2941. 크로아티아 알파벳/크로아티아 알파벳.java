import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] croatias = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String text = br.readLine();

        for(int i=0; i<croatias.length; i++) {
            if(text.contains(croatias[i])) {
                text = text.replace(croatias[i], "*");
            }
        }

        sb.append(text.length());
        System.out.print(sb.toString());
    }
}