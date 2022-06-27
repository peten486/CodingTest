import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/12865
 * 평범한배낭
 */


public class Main {
	
		static int[][] DP = new int[101][100001];
	 	static int N, K;
	 	
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        K = Integer.parseInt(st.nextToken());
	        
	        for( int i = 1; i <= N; i++ ) {
	        	st = new StringTokenizer(br.readLine());
	        	int w = Integer.parseInt(st.nextToken());
	        	int v = Integer.parseInt(st.nextToken());
	        	
	        	inputDP(i,w,v);
	        }
	        //printDP();
	        System.out.println(DP[N][K]);
	    }
	    
	    
	    public static void inputDP(int i, int w, int v) {
	    	for(int j = 1; j <= K; j++) {
	    		if( j - w >= 0 ) DP[i][j] = Math.max( DP[i-1][j], DP[i-1][j-w] + v );
	    		else DP[i][j] = DP[i-1][j];
	    	}
	    }
	    
	    public static void printDP() {
	    	System.out.println("---------------------------------------------------------------");
	    	for( int i = 1; i <= N; i++ ) {
	    		for( int j = 1; j <= K; j++ ) {
	    			System.out.print(DP[i][j] + "\t");
	    		}
	    		System.out.println();
	    	}
	    	System.out.println("---------------------------------------------------------------");
	    }
	    
	}

