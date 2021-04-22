import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


/*
 * https://www.acmicpc.net/problem/2231
 * 분해합
 */


public class Solution {
	
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.valueOf(br.readLine());
	        System.out.println(sol(N));
	    }
	    
	    public static int sol(int n) {
	    	ArrayList<Integer> list = new ArrayList<Integer>();
	    	int dist[] = new int[1000001];
	    	for( int i = n; i >= 0; i-- ) {
	    		dist[i] = i + getSum(i);
	    		if( dist[i] == n ) {
	    			list.add(i);
	    		}
	    	}
	    	Collections.sort(list);
	    	if( list.size() == 0 )
	    	{
	    		return 0;
	    	}
	    	return list.get(0);
	    }
	    
	    public static int getSum( int n ) {
	    	int arr[] = getDiv(n);
	    	int sum = 0;
	    	for( int i = 0; i < arr.length; i++ ) {
	    		sum += arr[i];
	    	}
	    	return sum;
	    }
	    
	    public static int[] getDiv( int n ) {
	    	int result[] = new int[7];
	    	int a = n;
	    	int temp = 0;
	    	
	    	if( a >= 1000000 )
	    	{
	    		result[0] = a / 1000000;
	    		temp = a % 1000000;
	    		a = temp;
	    	}
	    	if( a >= 100000 ) {
	    		result[1] = a / 100000;
	    		temp = a % 100000;
	    		a = temp;
	    	}
	    	if( a >= 10000 ) {
	    		result[2] = a / 10000;
	    		temp = a % 10000;
	    		a = temp;
	    	}
	    	if( a >= 1000 ) {
	    		result[3] = a / 1000;
	    		temp = a % 1000;
	    		a = temp;
	    	}
	    	if( a >= 100) {
	    		result[4] = a / 100;
	    		temp = a % 100;
	    		a = temp;
	    	}
	    	if( a >= 10) {
	    		result[5] = a/ 10;
	    		temp = a % 10;
	    		a = temp;
	    	}
	    	if( a> 0) {
	    		result[6] = a;
	    	}
	    	
	    	return result;
	    }
	    
	    /*
	     *  216
	     *  198 + 1 + 9 + 8 = 216
	     *  dist[1000000];
	     *  dist[216] = 216 + 2 + 1 + 6 ;
	     *  dist[ 
	     * */
	}

