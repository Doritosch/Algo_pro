import java.io.*;
import java.util.*;

/**
 * 12891 DNA 비밀번호
 *
 * s(문자열 길이), p(부분문자열 길이), line(문자열), m(최소 기준 배열), C[](각 문자 개수 배열), count
 * for(s만큼 반복) {
 *     문자열 받기
 * }
 * needs(dna 최소 개수) 받기
 *
 * for(0~p까지 반복) {
 *     첫 부분 문자열 받기
 *     C 배열에 문자열의 각 문자 개수 저장하기
 * }
 * for(i -> 1~s-p까지 반복) {
 *     line[i-1] 제거 및 C 갱신
 *     line[i+p-1] 추가 및 C 갱신
 *
 *     if ( 최소 개수 이상일때 ) count 증가
 * }
 */
class Main
{
    static int[] dna;
    static int[] mDna;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int count = 0;

        String line = br.readLine();

        dna = new int[4];
        mDna = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            mDna[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<p; i++) {
            char c = line.charAt(i);
            add(c);
        }

        if ( isCheck() ) {
            count++;
        }

        for(int i=0; i<s-p; i++) {
            remove(line.charAt(i));
            add(line.charAt(i+p));
            if ( isCheck() ) {
                count++;
            }
        }

        System.out.println(count);
    }
    public static void add(char ch) {
        if ( ch == 'A' ) {
            dna[0]++;
        } else if ( ch == 'C' ) {
            dna[1]++;
        } else if ( ch == 'G' ) {
            dna[2]++;
        } else if ( ch == 'T' ) {
            dna[3]++;
        }
    }
    public static void remove(char ch) {
        if ( ch == 'A' ) {
            dna[0]--;
        } else if ( ch == 'C' ) {
            dna[1]--;
        } else if ( ch == 'G' ) {
            dna[2]--;
        } else if ( ch == 'T' ) {
            dna[3]--;
        }
    }
    public static boolean isCheck() {
        for(int i=0; i<4; i++) {
            if ( mDna[i] > dna[i] ) {
                return false;
            }
        }
        return true;
    }
}