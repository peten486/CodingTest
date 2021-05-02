import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


/*
 * https://www.acmicpc.net/problem/1325
 * 효율적인 해킹 
 */

public class Solution {
		static int N, M;
		static int MAX;
		static int[] result;
		
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        boolean[] chk;
	        String[] s = br.readLine().split(" ");
	        N = Integer.valueOf(s[0]);
	        M = Integer.valueOf(s[1]);
	        
	        result = new int[N+1];
	        ArrayList<Integer>[] graph = new ArrayList[N+1];
	        
	        for( int i = 0; i <= N; i++ ) {
	        	graph[i] =  new ArrayList<>();
	        }
	        
	        for( int i = 0; i < M; i++ ) {
	        	s = br.readLine().split(" ");
		        int a = Integer.valueOf(s[0]);
		        int b = Integer.valueOf(s[1]);
	        	
	        	graph[a-1].add(b-1);
	        }
	        
	        for( int i = 0; i < N; i++) {
                chk = new boolean[N+1];
	        	dfs( i, chk, graph );
	        }
	        
	        for( int i = 0; i < N; i++ ) {
	        	if( MAX == result[i] ) {
	        		bw.write( (i+1) + " " );
	        	}
	        }
	        
	        bw.flush();
	        bw.close();
	    }
	    
	    public static void dfs(int v, boolean chk[], ArrayList<Integer>[] graph ) {
	    	chk[v] = true;
	    	for(int i=0; i<graph[v].size(); i++){
				int temp = graph[v].get(i);
				if( chk[temp] == false){
					result[temp]++;
                    if(MAX<=result[temp]) MAX=result[temp];
					dfs(temp, chk, graph);
				}
			}
	    }
}

