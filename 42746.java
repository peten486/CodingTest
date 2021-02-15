import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 * 가장 큰 수 

정확성  테스트
테스트 1 〉	통과 (1978.51ms, 358MB)
테스트 2 〉	통과 (673.10ms, 355MB)
테스트 3 〉	통과 (2908.51ms, 361MB)
테스트 4 〉	통과 (40.56ms, 60.9MB)
테스트 5 〉	통과 (1521.43ms, 358MB)
테스트 6 〉	통과 (1201.56ms, 357MB)
테스트 7 〉	통과 (2.41ms, 52.5MB)
테스트 8 〉	통과 (5.19ms, 52.8MB)
테스트 9 〉	통과 (2.43ms, 52.1MB)
테스트 10 〉	통과 (2.25ms, 52.5MB)
테스트 11 〉	통과 (2.17ms, 52.7MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0

 */


public class Solution {
	
	
	public static void main(String[] args) {
        
        int[] numbers = {3, 30, 34, 5, 9};

        String result = solution(numbers);
        System.out.println(result);
    }
	
	public static String solution(int[] numbers) {
        String result = "";
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < numbers.length; i++) {
        	list.add( String.valueOf(numbers[i]));
        }
        
        Descending ascending = new Descending();
        Collections.sort( list, ascending);
        if( list.get(0).equals("0") ) return "0";
        
        for(int i = 0; i < numbers.length; i++) {
        	result += list.get(i);
        }
        
        return result;
    }
	
	static class Descending implements Comparator<String> {
		 
	    @Override
	    public int compare(String o1, String o2) {
	        return (o2+o1).compareTo(o1+o2);
	    }
	}
	
}
