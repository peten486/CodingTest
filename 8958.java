import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * https://www.acmicpc.net/problem/8958
 * OX 퀴즈
 */

/*

5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX

10
9
7
55
30

 */

public class Main {
		public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int n = Integer.valueOf( br.readLine() );
	        
	        for( int i = 0; i < n; i++ ) {
	        	String cur_line = br.readLine();
	        	System.out.println(getGrade(cur_line));
	        }
	    }
	    
	    public static int getGrade ( String str ) {
	    	int grade = 0;
	    	int cur_grd = 1;
	    	for(int i = 0; i < str.length(); i++ ) {
	    		if( str.charAt(i) == 'O' ) {
	    			grade += cur_grd;
	    			cur_grd++;
	    		} else {
	    			cur_grd = 1;
	    		}
	    	}
	    	
	    	return grade;
	    }
}

