import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/9184
 * 신나는 함수 실행
 */

/*

#input
1 1 1
2 2 2
10 4 6
50 50 50
-1 7 18
-1 -1 -1


#output
w(1, 1, 1) = 2
w(2, 2, 2) = 4
w(10, 4, 6) = 523
w(50, 50, 50) = 1048576
w(-1, 7, 18) = 1

 */

public class Main {
		static long[][][] d = new long[101][101][101];
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			while( true ) {
				String[] temp = br.readLine().split(" ");
		        
				if( temp[0].equals("-1") && temp[1].equals("-1") && temp[2].equals("-1") ){
	        		break;
	        	}
				int a = Integer.valueOf(temp[0]);
				int b = Integer.valueOf(temp[1]);
				int c = Integer.valueOf(temp[2]);
				a+= 50;
				b+= 50;
				c+= 50;
				
	        	bw.write("w(" + temp[0]+ ", " + temp[1] + ", " + temp[2] + ") = " + sol( a, b, c ) + "\n");
	        }
			
	        bw.flush();
	        bw.close();
		}
		
		static long sol(int a, int b, int c) {
			
			if( d[a][b][c] != 0 ) {
				return d[a][b][c];
			}
			else if( a <= 50 || b <= 50 || c <= 50 ) {
				d[a][b][c] = 1;
				return d[a][b][c];
			} else if( a > 70 || b > 70 || c > 70 ) {
				d[70][70][70] = sol(70,70,70);
				d[a][b][c] = d[70][70][70];
				return d[a][b][c];
			} else if( a < b && b  < c ) {
				d[a][b][c-1] = sol(a,b,c-1);
				d[a][b-1][c-1] = sol(a,b-1,c-1);
				d[a][b-1][c] = sol(a,b-1,c);
				 
				d[a][b][c] = d[a][b][c-1] + d[a][b-1][c-1] - d[a][b-1][c];
				return d[a][b][c];
			} else {
				d[a-1][b][c] = sol(a-1,b,c);
				d[a-1][b-1][c] = sol(a-1, b-1,c);
				d[a-1][b][c-1] = sol(a-1,b,c-1);
				d[a-1][b-1][c-1] = sol(a-1,b-1,c-1);
				d[a][b][c] = d[a-1][b][c] + d[a-1][b-1][c] + d[a-1][b][c-1] - d[a-1][b-1][c-1];
				return d[a][b][c];
			}
		}
		
}

