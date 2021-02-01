
import java.util.Stack;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * 기능 개발  
 *  
 */

/*
       	progresses					speeds				return
		[93, 30, 55]				[1, 30, 5]			[2, 1]
		[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
        
*/

public class Solution {
	
	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] result = solution(progresses, speeds);
        for( int i = 0; i < result.length; i++)
        	System.out.println(result[i]);
    }
	
	static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = null;
        int[] result2 = null;
        int[] result = new int[progresses.length];
        Stack<Integer> stack = new Stack<>();
        for( int i = 0; i < progresses.length; i++) {
        	int temp = (100 - progresses[i]) / speeds[i];
        	if( ((100 - progresses[i]) % speeds[i] ) > 0) {
        		temp += 1;
        	}
        	
        	if( i == 0 )
        	{
        		stack.push(temp);
        	}
        	else{
        		if( stack.peek() >= temp ) {
        			stack.push(stack.peek());
        		} else 
        		{
        			stack.push(temp);
        		}
        	}
        }
        
        int cnt = 0;
        while( !stack.empty() ) {
        	int top = stack.pop();
        	result[cnt++] = top;
        }
        
        result2 = new int[cnt];
        int j = cnt -1;
        for( int i = 0; i<cnt; i++ ) {
        	if( i == 0 ) {
        		result2[j] = 1;
        	} else {
        		if( result[i] >= result[i-1]) {
        			result2[j]++;
        		} else {
        			j--;
        			result2[j]++;
        		}
        	}
        }
        
        answer = new int[cnt-j];
        int k = 0;
        for(int i= j; i < cnt; i++ ) {
        	answer[k++] = result2[i];
        }
        
        return answer;
    }
	
}
