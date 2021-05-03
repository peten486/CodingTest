import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


/*
 * https://www.acmicpc.net/problem/11866
 * 요세푸스 문제 0 
 */

public class Main {
		static int N, K;
		static Queue<Integer> queue = new LinkedList<>();
		
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        boolean[] chk;
	        String[] s = br.readLine().split(" ");
	        N = Integer.valueOf(s[0]);
	        K = Integer.valueOf(s[1]);
	        
	        for(int i = 1; i <= N; i++) {
	        	queue.offer(i);
	        }
	        
	      //  printQueue();
	        printJosephus();
	        
	    }
	    
	    public static void printQueue() {
	    	int temp = 0;
	    	for( int i = 0; i < queue.size(); i++ ) {
	    		temp = queue.poll();
	    		System.out.println( temp );
	    		queue.offer(temp);
	    	}
	    }
	    
	    public static void printJosephus( ) {
	    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    	
	    	int cnt = 1;
	    	String result = null;
	    	try {
	    		result = "<";
		    	while( queue.isEmpty() == false ) {
		    		int temp = queue.poll();
		    		if( cnt == K ) {
		    			
		    			if( queue.size() != 0) {
		    				result += ( temp + ", " );
		    			}
		    			else
		    			{
		    				result += temp;
		    			}
						cnt = 1;
		    		} else {
		    			queue.offer( temp );
		    			cnt++;
		    		}
		    	}
		    	result += ">";
		    	bw.write(result);
		    	bw.flush();
		        bw.close();
	    	} catch (IOException e) {
				e.printStackTrace();
			}
	    }
}

