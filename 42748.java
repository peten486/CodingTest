import java.util.Arrays;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 * k번째 수 
 */

/*
 * 
정확성  테스트
테스트 1 〉	통과 (1.73ms, 52.5MB)
테스트 2 〉	통과 (0.40ms, 52.4MB)
테스트 3 〉	통과 (1.06ms, 52.1MB)
테스트 4 〉	통과 (0.57ms, 52.3MB)
테스트 5 〉	통과 (0.46ms, 52.2MB)
테스트 6 〉	통과 (0.49ms, 52.6MB)
테스트 7 〉	통과 (1.09ms, 52.5MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0

 */

public class Solution {
	
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = solution( array, commands );
        for( int i = 0; i < result.length; i++ ) {
        	System.out.println(result[i]);
        }
    }
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < answer.length; i++) {
        	
        	
        	int[] temp = new int[commands[i][1] - commands[i][0] + 1];
        	int j_idx = 0;
        	for( int j = commands[i][0] - 1; j < commands[i][1]; j++, j_idx++ )
        	{
        		temp[j_idx] = array[j];
        	}
        	
        	Arrays.sort(temp);
        	
        	answer[i] = temp[commands[i][2]-1];
        }
        
        return answer;
    }
    
}
