import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/62048
 * 멀쩡한 사각형
 */

/*
입출력 예 
input
w : 8
h : 12

output
result : 80

 */


public class Main {
	

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//String s = br.readLine();

		int w = 1;
		int h = 2;
		Sol sol = new Sol();
		
		System.out.println("result : " + sol.solution(w,h) );
		
		//br.close();
	}	
}

class Sol {
	public long solution(int w, int h) {
		long wl = Long.parseLong(String.valueOf(w));
		long hl = Long.parseLong(String.valueOf(h));
        long answer = wl * hl;      
        long plus = wl + hl;
        long gcd = GetGcd(wl,hl);
        
        if( gcd == 1 ) {
        	answer = answer - (plus - 1);
        }else {
        	answer = answer - (plus-gcd);
        }
        return answer;
    }
	
	public long GetGcd(long w, long h) {
		long gcd = 0;
		for( int i = 1; i <= w && i <= h; i ++ ) {
			if( w%i == 0 && h%i == 0) 
				gcd = i;
		}
		return gcd;
	}
}


