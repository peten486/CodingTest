import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/*
 * https://www.acmicpc.net/problem/15649
 * N과 M(1)
 */

public class Solution {
	
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String str[] = br.readLine().split(" ");
	        sol(Integer.valueOf(str[0]), Integer.valueOf(str[1]));
	    }
	    
	    public static void sol(int a, int b) {
	    	int arr[] = new int[a];
	    	for(int i = 0; i < a; i++ ){
	    		arr[i] = i+1;
	    	}
	    	
	    	permutation( arr, 0, a, b);
	    }
	    
	    static void permutation(int[] arr, int depth, int n, int r) {
	    	if( depth == r ) {
	    		print(arr, r);
	    		return;
	    	}
	    	
	    	for(int i = depth; i < n; i++) {
	    		//swap(arr, i, depth);
	    		right_rotation( arr, depth, i);
	    		permutation(arr, depth+1, n, r);
	    		//swap(arr, i, depth);
	    		left_rotation( arr, depth, i);
	    	}
	    }
	    
	    static void swap(int[] arr, int i, int j ) {
	    	int temp = arr[i];
	    	arr[i] = arr[j];
	    	arr[j] = temp;
	    }
	    
	    static void left_rotation(int[]arr, int start, int end) {
	    	int first = arr[start];
	    	for(int i = start; i < end; i++ ) {
	    		arr[i] = arr[i+1];
	    	}
	    	arr[end] = first;
	    }
	    
	    static void right_rotation(int[]arr, int start, int end) {
	    	int last = arr[end];
	    	for(int i = end; i > start; i-- ) {
	    		arr[i] = arr[i-1];
	    	}
	    	arr[start] = last;
	    }
	    
	    static void print(int[] arr, int r) {
	    	for(int i = 0; i < r; i++) {
	    		if( i == r -1 ) {
	    			System.out.println(arr[i]);
	    		} else
	    			System.out.print( arr[i] + " ");
	    	}
	    }
	}

