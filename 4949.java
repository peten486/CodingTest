import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/*
 * https://www.acmicpc.net/problem/4949
 * 균형잡힌 세상
 */

/*

[][][][][][][][][][][]
()()(()()()()()()())
][]]][[]][][][]]][][][][


 */

public class Main {
		public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = null;
	        for( int i = 0; ( line = br.readLine()) != null; i++ ) {
	        	if( line.charAt(0) == '.') break;
	        	if( isCheckLine( line ) == true ) {
	        		System.out.println("yes");
	        	} else {
	        		System.out.println("no");
	        	}
	        }
	        
	    }
		
		public static boolean isCheckLine( String line ) {
			Stack<Character> stack = new Stack<Character>();
			char prev_char = '1';
			for( int i = 0; i < line.length(); i++ ) {
				switch( line.charAt(i) ) {
					case '(':
					case '[':
						stack.push( line.charAt(i) );
						break;
					case ')':
						if( stack.isEmpty() == true ) {
							return false;
						}
						prev_char = stack.pop();
						if( prev_char != '(' ) {
							return false;
						}
						break;
					case ']':
						if( stack.isEmpty() == true ) {
							return false;
						}
						prev_char = stack.pop();
						if( prev_char != '[' ) {
							return false;
						}
						break;
					case '.':
						if( stack.isEmpty() == false ) {
							return false;
						}
						break;
				}
			}
			
			return true;
		}
	    
}

