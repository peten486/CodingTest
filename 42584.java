import java.util.Stack;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 * 주식가격 
 *  
 */

/*
        1 -> 2, 3, 2, 3 = 4
        2 -> 3, 2, 3 = 3
        3 -> 2 = 1
        2 -> 3 = 1
        3 -> 0
        
        4,3,1,1,0
*/

public class Solution {
	
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
        int[] result = solution(prices);
        for( int i = 0; i < result.length; i++)
        	System.out.println(result[i]);
    }

	static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
       
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < prices.length; i++) {
        	while( !stack.empty() && prices[stack.peek()] > prices[i] ) {
        		int top = stack.pop();
        		answer[top] = i - top;
        	}
        	stack.push(i);
        }
        
        while( !stack.empty() ) {
        	int top = stack.pop();
        	answer[top] = prices.length - 1 - top;
        }
        
        return answer;
    }
	
}
