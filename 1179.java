import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * https://www.acmicpc.net/problem/1179
 * 마지막 요세푸스 문제
 */

/*
 * 1000000000000000 1
 * 
 * 1000000000000000
 */

public class Main {
		static long N, K;
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        String[] s = br.readLine().split(" ");
	        N = Long.parseUnsignedLong(s[0]);
	        K = Long.parseUnsignedLong(s[1]);
	        System.out.println( "result : " + (joseph(N,K)+1) );
	    }
	    
	    public static long joseph ( long n, long k) {
	        if (n==1) return 0;
	        if (k==1) return n-1;
	        if (k>n) return (joseph(n-1,k)+k)%n;
	        long cnt=n/k;
	        long res=joseph(n-cnt,k);
	        res-=n%k;
	        if (res<0) res+=n;
	        else res+=res/(k-1);
	        return res;
	    }
}

