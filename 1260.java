import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.w3c.dom.Element;


/*
 * https://www.acmicpc.net/problem/1260
 * DFS와 BFS
 */

/*
 * 
 * 
N M V
4 5 1
1 2
1 3
1 4
2 4
3 4

 * 
 */

public class Solution {
	
		static int N, M, V;
		static boolean[] chk = new boolean[1002];
		static int[][] map = new int[1002][1002];
		static Stack<Integer> stack = new Stack<>();
		static Queue<Integer> queue = new LinkedList<>();
		
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       
	        String[] s = br.readLine().split(" ");
	        
	        N = Integer.valueOf(s[0]);
	        M = Integer.valueOf(s[1]);
	        V = Integer.valueOf(s[2]);
	        
	        for( int i = 0; i < M; i++ ) {
	        	s = br.readLine().split(" ");
	        	
	        	int a = Integer.valueOf(s[0]);
	        	int b = Integer.valueOf(s[1]);
	        	map[b][a] = 1;
	        	map[a][b] = 1;
	        }
	        
	        dfs(V);
	        System.out.println();
	        Arrays.fill( chk,  false );
	        bfs(V);
	        System.out.println();
	    }
	    
	    public static void dfs(int v) {
	    	// depth 
	    	chk[v] = true;
			System.out.print(v + " ");
			for(int i=1; i<N+1; i++){
				if( map[v][i] == 1 && chk[i] == false){
					dfs(i);
				}
			}
	    }
	    
	    public static void bfs(int v) {
	    	// breath
	    	queue.add(v);
	    	chk[v] = true;
	    	
	    	while( !queue.isEmpty() ) {
	    		int cur = queue.poll();
	    		System.out.print( cur + " ");
		    		
	    		for(int i = 0; i <= N; i++ ) {
	    			if( map[cur][i] != 0 && chk[i] == false ) {
	    				queue.add(i);
	    				chk[i] = true;
	    			}
	    		}
			
	    	}
	    }
	    
	}

