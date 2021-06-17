import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * https://www.acmicpc.net/problem/1654
 * 랜선 자르기
 */

/*

5 6
105
204
302
401
500

200

 */

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_temp = br.readLine().split(" ");
		
		int K = Integer.parseInt( str_temp[0] );
		int N = Integer.parseInt( str_temp[1] );
		
		long min = 1, max = 0;
		long[] arr = new long[K];
		for( int i = 0; i < K; i++ ) {
			arr[i] = Long.parseLong( br.readLine() );
			max = Math.max(max, arr[i]);
		}
		
		Arrays.sort(arr);
		long result = 0;
		
		while(min <= max) {
			long mid = ( min + max ) / 2;
			if( isCorrect(N, mid, arr) == true )
			{
				result = Math.max(result, mid);
				min = mid + 1;
			}
			else {
				max = mid - 1;
			}
		}
		
		
		System.out.println(result);
	
	}
	
	static boolean isCorrect(int N, long num, long[] arr) {
		long ok_cnt = 0;
		for(int i = 0; i < arr.length; i++ ) {
			ok_cnt += arr[i] / num;
		}
		if( ok_cnt >= N ) {
			return true;
		}
		return false;
	}
}


