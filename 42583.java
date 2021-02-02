
import java.util.LinkedList;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * 다리를 지나는 트럭
 *  
 */

public class Solution {
	static LinkedList<Integer> list = new LinkedList<Integer>();
	static LinkedList<Integer> list_w = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		int[] truck_weights = {7, 4, 5, 6};
		int[] truck_weights2 = {10};
		int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};
		int bridge_length = 2;
		int bridge_length2 = 100;
		int bridge_length3 = 100;
		int weight = 10;
		int weight2 = 100;
		int weight3 = 100;
        int result = solution(bridge_length3, weight3, truck_weights3);
        System.out.println(result);
    }
	
	static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 2;
        boolean chk = false;
        int i = 0;
  
    	list.add( bridge_length );
    	list_w.add( truck_weights[i] );
    	i++;
        
        while( !list.isEmpty() ) {
       		minusArray();
       		int prev_w = getWeight();
       		if( truck_weights.length > i ) {
       			prev_w += truck_weights[i];
       		}
       		//System.out.println( "[answer] "+ answer + " : " + prev_w );
        		
       		if( prev_w > weight ) {
       		//	System.out.println("pass");
        			
       		} else if( truck_weights.length > i ) {
       			
        		list.add( bridge_length );
        		list_w.add( truck_weights[i] );
        		i++;
        	}
        	
        	answer++;
        }
        
        return answer - 1;
    }
	
	static int getWeight() {
		int result = 0;
		for( int i = 0; i < list_w.size(); i++ ) {
			result += list_w.get(i);
		}
		return result;
	}
	
	static void minusArray( ) {
		
		/*for(int i = 0; i < list.size(); i++ ) {
			System.out.println(i + " : " + list.get(i));
		}*/
		
		for(int i = 0; i < list.size(); i++ ) {
			list.set(i, list.get(i) - 1 );
		}
		
		if( list.size() > 0 && list.get(0) == 0 ) {
			list.remove();
			list_w.remove();
		}
		
		/*for(int i = 0; i < list.size(); i++ ) {
			System.out.println( "r :: " + i + " : " + list.get(i));
		}*/
	}
	
}
