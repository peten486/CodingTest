import java.util.PriorityQueue;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 * 더 맵게
 *   
 */

/*
 * 

정확성  테스트
테스트 1 〉	통과 (0.41ms, 53.2MB)
테스트 2 〉	통과 (0.48ms, 52.8MB)
테스트 3 〉	통과 (0.41ms, 52.8MB)
테스트 4 〉	통과 (0.47ms, 52.1MB)
테스트 5 〉	통과 (0.72ms, 52.8MB)
테스트 6 〉	통과 (3.13ms, 53.3MB)
테스트 7 〉	통과 (6.69ms, 52.6MB)
테스트 8 〉	통과 (0.75ms, 51.9MB)
테스트 9 〉	통과 (1.02ms, 52.5MB)
테스트 10 〉	통과 (2.97ms, 52.2MB)
테스트 11 〉	통과 (3.16ms, 52.2MB)
테스트 12 〉	통과 (4.56ms, 53.5MB)
테스트 13 〉	통과 (3.68ms, 52.6MB)
테스트 14 〉	통과 (0.43ms, 52.4MB)
테스트 15 〉	통과 (5.68ms, 52.3MB)
테스트 16 〉	통과 (0.48ms, 53.7MB)

효율성  테스트
테스트 1 〉	통과 (148.51ms, 66.3MB)
테스트 2 〉	통과 (305.20ms, 89MB)
테스트 3 〉	통과 (1403.06ms, 124MB)
테스트 4 〉	통과 (135.95ms, 65.8MB)
테스트 5 〉	통과 (1462.19ms, 123MB)

채점 결과
정확성: 76.2
효율성: 23.8
합계: 100.0 / 100.0

 */

public class Solution {
	
	
	
	public static void main(String[] args) {
		int[] scoville = {1, 2};
		int K = 7;
        int result = solution(scoville, K );
        System.out.println(result);
    }
	
	static int solution(int[] scoville, int K) {
        int answer = 0;
        int cur_scoville = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++ ) {
        	queue.add( scoville[i] );
        }
        
        for(int i = 0; i < scoville.length; i++ ) {
        	int a_value = queue.poll();
        	int b_value = 0;
        	
        	if( queue.peek() == null ) {
        		return -1;
        	} else {
        		b_value = queue.poll();
        	}
        	
        	cur_scoville = a_value + ( b_value * 2 );
        	answer++;
        	System.out.println("cur[" + cur_scoville +"], a[" + a_value + "], b["+b_value+"]" );
        	queue.add( cur_scoville );
        	
        	if( queue.peek() > K ) {
        		break;
        	}
        }
        
        return answer;
    }
}
