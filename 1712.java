import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * https://www.acmicpc.net/problem/1712
 * 손익분기점
 */


public class Solution {
	
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       
	        String[] s = br.readLine().split(" ");
	        
	        // 고정비용 
	        long A = Long.valueOf(s[0]); 
	        // 가변비용
	        long B = Long.valueOf(s[1]);
	        // 노트북 가격
	        long C = Long.valueOf(s[2]);
	        
	        System.out.println(sol(A,B,C));
	    }
	    
	    public static long sol(long a, long b, long c) {
	    	long temp = c - b;
	    	long temp2 = 0;
	    	
	    	if( temp == 0 ) return -1;
	    	
	    	temp2 = a / temp;
	    	
	    	if( temp2 >= 0 ) {
	    		return temp2 + 1;
	    	}
	    	else 
	    		return -1;
	    }
	    
	}

