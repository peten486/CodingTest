
/*
 * https://programmers.co.kr/learn/courses/30/lessons/12914
 * 멀리 뛰기
 * 
 * dfs 로 풀었을 경우에는, 모든 케이스를 통과하지 못하고, 시간초과나 StackOverflow 에 걸렸음.
 * 그래서 n를 하나씩 올리니까 결과가 피보나치 수열과 동일하다는 것을 발견 

 아래는 테스트 확인

테스트 1 〉	통과 (0.14ms, 51.8MB)
테스트 2 〉	통과 (0.15ms, 54.5MB)
테스트 3 〉	통과 (0.12ms, 52MB)
테스트 4 〉	통과 (0.10ms, 53MB)
테스트 5 〉	통과 (0.20ms, 52.4MB)
테스트 6 〉	통과 (0.12ms, 51.6MB)
테스트 7 〉	통과 (0.13ms, 51.9MB)
테스트 8 〉	통과 (0.15ms, 54MB)
테스트 9 〉	통과 (0.12ms, 52.4MB)
테스트 10 〉	통과 (0.14ms, 51.9MB)
테스트 11 〉	통과 (0.16ms, 52.3MB)
테스트 12 〉	통과 (0.13ms, 53MB)
테스트 13 〉	통과 (0.13ms, 52.3MB)
테스트 14 〉	통과 (0.13ms, 55.4MB)
테스트 15 〉	통과 (0.14ms, 52.5MB)
테스트 16 〉	통과 (0.13ms, 53.9MB)

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
