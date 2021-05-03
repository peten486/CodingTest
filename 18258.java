import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;


/*
 * https://www.acmicpc.net/problem/18258
 * 큐 2 
 */

public class Main {
		static int N;
		static Queue<Integer> queue = new LinkedList<>();
		static int lastValue;
		
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	        N = Integer.valueOf(br.readLine());
	        lastValue = -1;
	        for( int i = 0; i < N; i++ ) {
	        	String[] s = br.readLine().split(" ");
	        	
	        	switch( s[0] ) {
		        	case "push":
		        		int temp = Integer.valueOf(s[1]);
		        		queue.offer( temp );
		    	    	lastValue = temp  ;
		        		break;
		        	case "pop":
			        	if( queue.size() == 0 )
			        		bw.write("-1");
					    else{
					    	bw.write( String.valueOf (queue.poll()) );
					    }
			        	bw.write("\n");
		        		break;
		        	case "size":
		        		bw.write(String.valueOf( queue.size() ));
			        	bw.write("\n");
		        		break;
		        	case "empty":
		        		if(queue.isEmpty() == true) {
		        			bw.write("1");
		        		}else {
		        			bw.write("0");
		        		}
			        	bw.write("\n");
		        		break;
		        	case "front":
		        		if( queue.size() == 0 )
			        		bw.write("-1");
					    else{
					    	bw.write( String.valueOf( queue.peek() ) );
					    }
			        	bw.write("\n");
		        		break;
		        	case "back":
		        		if( queue.size() == 0 )
		        			bw.write("-1");
		    		    else {
		    		    	bw.write(String.valueOf(lastValue));
		    		    }
		        		bw.write("\n");
		        		break;
		        }
	        	
	        	
	        }
	        
	        bw.flush();
	        bw.close();
	    }
	    
}

