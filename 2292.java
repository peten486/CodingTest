import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * https://www.acmicpc.net/problem/2292
 * 벌집 
 */


public class Solution {
	
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.valueOf(br.readLine());
	        System.out.println(sol(N));
	    }
	    
	    public static int sol(int n) {
	    	int i = 1;
	    	int cur = 1;
	    	while( true ) {
	    		int temp =  ( 6 * i );
	    		
	    		if( cur >= n )
	    		{
	    			return i;
	    		}
	    		
	    		cur += temp;
	    		i++;
	    	}
	    	
	    }
	    
	}

