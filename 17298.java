import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/17298
 * 오큰수 
 */

/*

#input 1
4
3 5 2 7

#output 1
5 7 7 -1


#input 2
4
9 10 4 6

#output 2
10 -1 6 -1

 */

public class Main {
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			Stack<Integer> stack = new Stack<Integer>();
			
			int n = Integer.valueOf(br.readLine());      
	        int[] data = new int[n];
	        String[] temp = br.readLine().split(" ");
	        for( int i = 0; i < n; i++ ) {
	        	data[i] = Integer.valueOf(temp[i]);
	        }
			
	        for( int i = 0; i < n; i++ ) {
	        	/*
	        	 * 스택이 비어있지 않고,
	        	 * data[stack의 top부분] < data[i] 이라면,
	        	 * data[stack의 top부분] = data[i]; 오큰수 성립
	        	 */
	        	while( stack.isEmpty() == false && data[stack.peek()] < data[i] ) {
	        		data[stack.pop()] = data[i];
	        	}
	        	stack.push(i);
	        }
	        
	        /* stack에 남아있는 index들은 전부 오큰수가 없는 index. */
	        while(!stack.isEmpty()) {
	        	data[stack.pop()] = -1;
	        }
	        
	        for(int i = 0; i < n; i++) {
	        	bw.write(data[i] + " " );
			}
	        
	        bw.flush();
	        bw.close();
		}
		
}

