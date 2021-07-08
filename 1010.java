import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.acmicpc.net/problem/1010
 * 다리놓기 
 */

/*

3
2 2
1 5
13 29

 */


public class Main {
	static int[][] comp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N,M,T;
		int result = 0;
		
		comp = new int[31][31];
		
		AllCombination();
		
		T = Integer.valueOf( br.readLine().trim() );
		
		for( int i = 0; i < T; i++ ) {
			String[] temp_str = br.readLine().split(" ");
			N = Integer.valueOf(temp_str[0].trim());
			M = Integer.valueOf(temp_str[1].trim());

			result = comp[M][N];
			
		//	System.out.print("result : ");
			System.out.println(result);			
		}
		
	}
	
	public static void AllCombination( ) {
		// [n][r] 이다.
	    comp[1][0] = 1;    
	    comp[1][1] = 1;
	    for (int i = 2; i <= 30; i++){
	    	comp[i][0] = 1;
	        for (int j = 1; j <= 30; j++){
	        	comp[i][j] = comp[i - 1][j - 1] + comp[i - 1][j];
	         }
	    }
	}
}


