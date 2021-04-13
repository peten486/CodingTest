import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/1316
 * 그룹 단어 체커 
 */


public class Solution {
	
	    
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        int cnt = 0;
	        
	        for( int i = 0; i < N; i++ ) {
	        	String cur_word = br.readLine();
	        	if( ChkGroupWord(cur_word) == true )
	        	{
	        		cnt++;
	        	}
	        }
	        
	        System.out.println(cnt);
	        
	    }
	    
	    public static boolean ChkGroupWord( String str ) {
	    	int[] alpha = new int[26];
	    	int prev_char = -1;
	    	for( int i = 0; i < str.length(); i++ ) {
	    		int cur = str.charAt(i) - 'a';
	    		if( i > 0 ) {
	    			if ( prev_char == cur ){
	    				alpha[cur]++;
	    				continue;
	    			}
	    		}
	    		if( alpha[cur] > 0 ) {
	    			return false;
	    		} else {
	    			alpha[cur]++;
	    		}
	    		
	    		prev_char = cur;
	    	}
	    	
	    	return true;
	    }
	    
	}

