/*
 * https://programmers.co.kr/learn/courses/30/lessons/12977
 * 소수 만들기 

  아래는 테스트 확인

테스트 1 〉	통과 (1.48ms, 51.8MB)
테스트 2 〉	통과 (1.87ms, 52.1MB)
테스트 3 〉	통과 (0.86ms, 52.7MB)
테스트 4 〉	통과 (0.78ms, 52.8MB)
테스트 5 〉	통과 (2.42ms, 52.8MB)
테스트 6 〉	통과 (3.42ms, 53MB)
테스트 7 〉	통과 (0.29ms, 52MB)
테스트 8 〉	통과 (6.77ms, 52.5MB)
테스트 9 〉	통과 (0.89ms, 52.1MB)
테스트 10 〉	통과 (7.03ms, 53.5MB)
테스트 11 〉	통과 (0.12ms, 52.9MB)
테스트 12 〉	통과 (0.08ms, 52.1MB)
테스트 13 〉	통과 (0.16ms, 53.5MB)
테스트 14 〉	통과 (0.08ms, 51.7MB)
테스트 15 〉	통과 (0.08ms, 52.8MB)
테스트 16 〉	통과 (8.48ms, 51.7MB)
테스트 17 〉	통과 (8.91ms, 53MB)
테스트 18 〉	통과 (0.12ms, 52.6MB)
테스트 19 〉	통과 (0.06ms, 52.6MB)
테스트 20 〉	통과 (10.35ms, 53.1MB)
테스트 21 〉	통과 (9.29ms, 51.9MB)
테스트 22 〉	통과 (1.97ms, 52.2MB)
테스트 23 〉	통과 (0.03ms, 52MB)
테스트 24 〉	통과 (8.74ms, 52.6MB)
테스트 25 〉	통과 (7.47ms, 52.4MB)
테스트 26 〉	통과 (0.04ms, 53MB)

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
