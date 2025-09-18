import java.io.*;
import java.util.*;
class Solution {
    public String solution(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new StringBuilder(new String(ch)).reverse().toString();
    }
}