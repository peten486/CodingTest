
/*
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 * 카펫   
 */

/*
 * 

정확성  테스트
테스트 1 〉	통과 (0.02ms, 52.4MB)
테스트 2 〉	통과 (0.02ms, 52.7MB)
테스트 3 〉	통과 (0.04ms, 53.1MB)
테스트 4 〉	통과 (0.02ms, 52.8MB)
테스트 5 〉	통과 (0.02ms, 52.7MB)
테스트 6 〉	통과 (0.02ms, 52.3MB)
테스트 7 〉	통과 (0.03ms, 52.1MB)
테스트 8 〉	통과 (0.04ms, 51.9MB)
테스트 9 〉	통과 (0.03ms, 53MB)
테스트 10 〉	통과 (0.04ms, 52.2MB)
테스트 11 〉	통과 (0.03ms, 52.4MB)
테스트 12 〉	통과 (0.01ms, 52.9MB)
테스트 13 〉	통과 (0.02ms, 54.1MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0

 */

public class Solution {
	
	public static void main(String[] args) {
		int brown = 10, yellow = 2;
		int brown2 = 8, yellow2 = 1;
        int[] result = solution( 24, 24 );
        for( int i = 0; i < result.length; i++ ) {
        	System.out.println(result[i]);
        }
    }
	
    static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int d = brown + yellow;
        int a = 0, b = 0;
        
        for (int height = 3; ; height++) {
            if (( d % height) == 0) {
                int weight = d / height;
                if (((height - 2) * (weight - 2)) == yellow) {
                    a = weight;
                    b = height;
                    break;
                }
            }
        }
        
        answer[0] = a;
        answer[1] = b;
        return answer;
    }
    
}
