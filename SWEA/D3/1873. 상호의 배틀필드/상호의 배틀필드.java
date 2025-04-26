/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static char[][] field;
    static int dir;
    static Node cur;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            field = new char[n][m];
            
            for(int i=0; i<n; i++) {
                String line = br.readLine();
            	for(int j=0; j<m; j++) {
                    char form = line.charAt(j);
                    if ( form == '<' || form == '>' || form == '^' || form == 'v' ) {
                    	cur = new Node(i,j);
                    }
                	field[i][j] = line.charAt(j);
                }
            }
            checkDir(cur.x, cur.y);
            
            int count = Integer.parseInt(br.readLine());
            String command = br.readLine();
            run(count, command);
            
            System.out.print("#" + test_case + " ");
            printField();
		}
	}
    public static void printField() {
    	for(int i=0; i<field.length; i++) {
        	for(int j=0; j<field[0].length; j++) {
            	System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
    public static void checkDir(int x, int y) {
    	if ( field[x][y] == '>' ) {
        	dir = 0;
        } else if ( field[x][y] == 'v' ) {
            dir = 1;
        } else if ( field[x][y] == '<' ) {
            dir = 2;
        } else if ( field[x][y] == '^' ) {
            dir = 3;
        }
    }
    public static void shot() {
        Node shotPos = new Node(cur.x, cur.y);
    	while(true) {
        	shotPos.x += dx[dir];
            shotPos.y += dy[dir];
            
            if ( (shotPos.x<0 || shotPos.y<0) || (shotPos.x>=field.length || shotPos.y>=field[0].length) ) {
            	break;
            }
            
            if ( field[shotPos.x][shotPos.y] == '*' ) {
            	field[shotPos.x][shotPos.y] = '.';
                break;
            }
            
            if ( field[shotPos.x][shotPos.y] == '#' ) {
            	break;
            }
        }
    }
    public static void run(int count, String commands) {
    	for(int i=0; i<count; i++) {
        	char command = commands.charAt(i);
            int xPos = cur.x;
            int yPos = cur.y;
            
            if ( command == 'U' ) {
            	if ( xPos-1>=0 && field[xPos-1][yPos] == '.' ) {
                	field[xPos][yPos] = '.';
                    xPos -= 1;
                }
                dir = 3;
                field[xPos][yPos] = '^';
            } else if (command == 'R' ) {
            	if ( yPos+1<field[0].length && field[xPos][yPos+1] == '.' ) {
                	field[xPos][yPos] = '.';
                    yPos += 1;
                }
                dir = 0;
                field[xPos][yPos] = '>';
            } else if (command == 'D' ) {
            	if ( xPos+1<field.length && field[xPos+1][yPos] == '.' ) {
                	field[xPos][yPos] = '.';
                    xPos += 1;
                }
                dir = 1;
              	field[xPos][yPos] = 'v';
            } else if (command == 'L' ) {
            	if ( yPos-1>=0 && field[xPos][yPos-1] == '.' ) {
                	field[xPos][yPos] = '.';
                    yPos -= 1;
                }
                dir = 2;
                field[xPos][yPos] = '<';
            } else if (command == 'S' ) {
            	shot();
            }
            cur.x = xPos;
            cur.y = yPos;
        }
    }
    static class Node {
    	int x;
        int y;
        public Node(int x, int y) {
        	this.x = x;
            this.y = y;
        }
    }
}