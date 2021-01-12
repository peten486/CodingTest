/*
 * https://programmers.co.kr/learn/courses/30/lessons/12977
 * 소수 만들기 
 */


public class Solution {
	
	public static void main(String[] args) {
        
        int[] arr = {1,2,7,6,4};

        int result = solution(arr);
        System.out.println(result);
    }
	
	static int combination(int[] arr, boolean[] visited, int start, int n, int r ) {
	    int result = 0;
		if(r == 0) {
	    	int temp = sum(arr, visited, n);
	        if( isPrimeNumber(temp) == true )
	        {
	        	return 1;
	        }
	    	return 0;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        result += combination(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	    
	    return result;
	}
	
	static boolean isPrimeNumber( int value ) {
		if( value <= 1 )
	        return false;
		
		if( value % 2 == 0) 
	        return value == 2 ? true : false;
	         
	    for(int i = 3; i <= Math.sqrt(value); i += 2) { 
	        if( value % i == 0)
	            return false;
	    }
	    
		return true; 
	}
	
	static int sum( int[] arr, boolean[] visited, int n ) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += arr[i];
            }
        }
		return sum;
	}
	
	public static int solution(int[] nums) {
        int answer = -1;
        int n = nums.length;
        boolean[] visited = new boolean[n];
        
        answer = combination(nums, visited, 0, n, 3);
        
        return answer;
    }
	
}
