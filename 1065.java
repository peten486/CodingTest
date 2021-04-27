import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/*
 * https://www.acmicpc.net/problem/1065
 * 한수
 */

public class Solution {
	
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println( sol(Integer.valueOf(br.readLine().trim())) );
	    }
	    
	    public static int sol(int n) {
	    	int result = 0;
	    	if( n == 1 ) return 1;
	    	
	    	for( int i =1; i <= n; i++ ) {
	    		if(0<i && i<100) {
	    			result++;
	    		} 
	    		else
	    		{
		    		int[] arr = getDivide(i);
		    		int d1 = arr[2] - arr[1];
		    		int d2 = arr[1] - arr[0];
		    	
		    		if(d1 == d2 ) {
		    			result++;
		    		}
	    		}
	    	}
	    	
	    	return result;
	    }
	    
	    public static int[] getDivide( int n ) {
	    	int[] arr = new int[3];
	    	int temp = n;
	    	
	    	if( temp >= 100 ) {
	    		arr[0] = temp / 100;
	    		temp = temp % 100;
	    	}
	    	
	    	if( temp >= 10 ) {
	    		arr[1] = temp / 10;
	    		temp = temp % 10;
	    	}
	    	
	    	arr[2] = temp;
	    	
	    	return arr;
	    }
	}

