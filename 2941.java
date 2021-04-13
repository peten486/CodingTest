import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2941
 * 크로아티아 알파벳 
 */


public class Solution {
	
		
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int cnt = replaceWord( br.readLine() );
	        System.out.println(cnt);
	    }
	    
	    public static int replaceWord( String word ) {
	    	int cnt = 0;
	    	String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		    String cur = word;
	    	for( int i = 0; i < croatia.length; i++ ) {
	    		 while( cur.contains(croatia[i]) ) {
	    			 //System.out.println(cur);
	    			 cur = cur.replace( croatia[i], "!" );
	    			 
	    		 }
	    	}
	    	//System.out.println(cur);
	    	for( int i = 0; i < cur.length(); i++ ) {
	    		cnt++;
	    	}
	    	
	    	return cnt;
	    }
	    
	}

