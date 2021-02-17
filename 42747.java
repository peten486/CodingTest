
import java.util.Arrays;
import java.util.Collections;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 * H-Index
 */


public class Solution {
	
	
	public static void main(String[] args) {

        int[] citations = {3, 0, 6, 1, 5};
        int[] citations2 = {1, 7, 0,1,6,4};
        int[] citations3 = {1545,2,999,790,540,10,22};
        int[] citations4 = {0};
        int[] citations5 = {7};
        
        int result = solution(citations5);
        System.out.println("result : " +result);
    }
	
	public static int solution(int[] citations) {
		Integer[] arr = new Integer[citations.length];
		
		for(int i = 0; i < citations.length; i++ ) {
			arr[i] = citations[i];
		}
		
		Arrays.sort(arr, Collections.reverseOrder() );
		
		int i = 0;
		for(i = 0; i < arr.length; i++) {
		//	System.out.println(arr[i]);
		
			if( i >= arr[i] ) {
				return i;
			}
		}
		return i;
	}
	
}
