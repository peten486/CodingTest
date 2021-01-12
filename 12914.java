
/*
 * https://programmers.co.kr/learn/courses/30/lessons/12914
 * 멀리 뛰기
 * 
 * dfs 로 풀었을 경우에는, 모든 케이스를 통과하지 못하고, 시간초과나 StackOverflow 에 걸렸음.
 * 그래서 n를 하나씩 올리니까 결과가 피보나치 수열과 동일하다는 것을 발견 
 */


public class Solution {
	
	public static void main(String[] args) {
        long result = solution(2000);
        System.out.println(result);
    }

	static public long solution(int n) { 
		long dp[] = new long[2001]; 
		dp[1] = 1; 
		dp[2] = 2; 
		for(int i=3;i<=2000; i++) 
			dp[i] = (dp[i-1] + dp[i-2]) % 1234567; 
		return dp[n]; 
	}
	
}
