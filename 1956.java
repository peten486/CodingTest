import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1956
 * 운동  
 */

/*

5 8
1 2 10
1 3 1
1 4 1
1 5 1
2 1 1
3 2 1
4 3 1
5 4 1

3


5 9
1 2 10
1 3 1
1 4 1
1 5 1
2 1 1
3 2 1
4 3 1
5 4 1
3 1 1

2


 */


public class Main {
	    
	static class Edge implements Comparable<Edge> {
        int v, totalWeight;
 
        public Edge(int v, int weight) {
            this.v = v;
            this.totalWeight = weight;
        }
 
        @Override
        public int compareTo(Edge o) {
            return totalWeight - o.totalWeight;
        }
    }
	
	static Queue<Edge> que = new PriorityQueue<>();
	static List<Edge>[] adj_list;
	static final int INF = Integer.MAX_VALUE;
	static int[][] dist;
	static int v, e;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());    // 정점의 개수
        e = Integer.parseInt(st.nextToken());    // 간선의 개수
        
        
        adj_list = new ArrayList[v+1];
        dist = new int[v+1][v+1];
        
        for( int i = 1; i <= v; i++ ) {
        	adj_list[i] = new ArrayList<>();
        	for( int j = 1; j <= v; j++ ) {
        		dist[i][j] = INF;
        	}
        }
        for (int i = 0; i < e; i++)  {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            adj_list[a].add( new Edge(b, w ) );
        
        }
    
        for( int i = 1; i <= v; i++ ) {
        	Dijkstra(i);
        }
        
        int result = INF;
        for(int i = 1; i <= v; i++ ) {
        	for(int j = 1; j <= v; j++) {
        		if( i == j ) {
        			result = Math.min( result, dist[i][j] );
        		}
        	}
        }
        
        if( result == INF ) {
        	result = -1;
        }
        
        System.out.println(result);
    }
    
    static void Dijkstra( int start ) {
    	que.add( new Edge(start, 0) );
    	
    	while( !que.isEmpty() ) {
    		Edge cur_edge = que.poll();
    		int cur_v = cur_edge.v;
    		int cur_w = cur_edge.totalWeight;
    		
    		if( dist[start][cur_v] < cur_w ) continue;
    		
    		for( Edge e : adj_list[cur_v] ) {
    			int next_v = e.v;
    			int next_w = cur_w + e.totalWeight;
    			
    			if( dist[start][next_v] > next_w ) {
    				dist[start][next_v] = next_w;
    				que.add( new Edge(next_v, next_w) );
    			}
    		}
    	}
    }
    
    
    
}

