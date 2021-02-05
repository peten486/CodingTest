import java.util.ArrayList;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 * 소수 찾기
 *   
 */

/*
 * 

정확성  테스트
테스트 1 〉	통과 (0.14ms, 52.6MB)
테스트 2 〉	통과 (2.53ms, 51.9MB)
테스트 3 〉	통과 (0.05ms, 53.1MB)
테스트 4 〉	통과 (3.00ms, 51.5MB)
테스트 5 〉	통과 (3.31ms, 52.9MB)
테스트 6 〉	통과 (0.06ms, 52.8MB)
테스트 7 〉	통과 (0.18ms, 52.6MB)
테스트 8 〉	통과 (4.00ms, 52.5MB)
테스트 9 〉	통과 (0.07ms, 52.9MB)
테스트 10 〉	통과 (3.77ms, 53.2MB)
테스트 11 〉	통과 (0.70ms, 51.8MB)
테스트 12 〉	통과 (0.49ms, 52.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0

 */

public class Solution {
	
	public static void main(String[] args) {
		String numbers = "011";
        int result = solution( numbers );
        System.out.println(result);
    }
	
	static ArrayList<Integer> prime_numbers = new ArrayList<Integer>();
    
    static int solution(String numbers) {
        int[] arr = new int[numbers.length()];
        
        for( int i = 0; i < arr.length; i++ ) {
        	arr[i] = numbers.charAt(i) - '0';
        //	System.out.println("arr["+i+"] : "+ arr[i] );
        }
        
        for( int i = 1; i <= arr.length + 1; i++ ) {
        	permutation(arr, 0, arr.length, i );
        }
   
        return prime_numbers.size();
    }
    
    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
        	getNumber(arr, r);
            return;
        }
     
        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }
    
    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    
    static void getNumber(int[] arr, int r) {
    	int number = 0;
    	for (int i = 0; i < r; i++) {
        	if( i != r ) {
        		number *= 10;
        	}
        	number += arr[i];
        }
    	
    	if( isPrime(number) == true ) {
	        if( prime_numbers.contains(number) == false ) {
	        //	System.out.println("num : "+ number);
	        	prime_numbers.add(number);
	        }
        }
    }
    
    
    static boolean isPrime( int number ){
    	if( number == 0 || number == 1) return false;
        for(int i=2; i*i<=number; i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}
