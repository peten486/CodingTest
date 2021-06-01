import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1504
 * 특정한 최단 경로 
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
	            return Integer.compare(this.totalWeight, o.totalWeight);
	        }
	        
	    }
	    
	 	static List<Edge>[] adj;
	 	static int INF = 200000*1000;
	 	
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int V = Integer.parseInt(st.nextToken());    // 정점의 개수
	        int E = Integer.parseInt(st.nextToken());    // 간선의 개수
	        
	        // 인접 리스트 준비
	        adj = new ArrayList[V+1];
	        for (int i = 0; i <= V; i++) 
	            adj[i] = new ArrayList<>();
	        
	        // 간선 정보 입력
	        for (int i = 0; i < E; i++)  {
	            st = new StringTokenizer(br.readLine());
	            
	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());
	            int c = Integer.parseInt(st.nextToken());
	            
	            adj[a].add(new Edge(b,c));
	            adj[b].add(new Edge(a,c));
	        }
	    
	        st = new StringTokenizer(br.readLine());
	        
	        // 필수 노드 입력
	        int[] req = new int[2];
	        req[0] = Integer.parseInt(st.nextToken());
	        req[1] = Integer.parseInt(st.nextToken());
	        int[] dist = new int[V+1];
	        boolean[] check = new boolean[V+1];
	        
	        int result1, result2;
	        // 경로 1
	        // 1 -> 필수 1 최단거리
	        result1 = dijkstra(dist, check, 1, req[0]);
	        // 필수 1 -> 필수 2 최단거리
	        result1 += dijkstra(dist, check, req[0], req[1]);
	        
	        // 필수 2 -> N까지의 최단거리 
	        result1 += dijkstra(dist, check, req[1], V);
	        
	        // 경로 2
	        // 1 -> 필수 2 최단거리
	        result2 = dijkstra(dist, check, 1, req[1]);
	        
	        // 필수 2 -> 필수 1 최단거리
	        result2 += dijkstra(dist, check, req[1], req[0]);
	        
	        // 필수 1 -> N까지의 최단거리 
	        result2 += dijkstra(dist, check, req[0], V);
	        
	       /* System.out.println("result1 : "+ result1);
	        System.out.println("result2 : "+ result2);
	        */
	        
	        if( result1 >= INF && result2 >= INF )
	        	System.out.println("-1");
	        else
	        	System.out.println(Math.min( result1, result2));
	        
	        
	    }
	    
	    
	    private static int dijkstra(int[] dist, boolean[] check, int start, int end) {
	    	Arrays.fill( dist, INF );
	    	Arrays.fill( check, false );
	    	
	    	PriorityQueue<Edge> queue = new PriorityQueue<>();
	        queue.add(new Edge(start, 0));
	        Edge cur = null;
	        dist[start] = 0;
	        
	        while(!queue.isEmpty()) {
	        	
	            cur = queue.poll();
	            if(check[cur.v]) continue;
	            check[cur.v] = true;
	            
	            for (int i = 0; i < adj[cur.v].size(); i++ ) {
	            	Edge next = adj[cur.v].get(i);
	            	
	                if(!check[next.v] && dist[next.v] > cur.totalWeight + next.totalWeight) {
	                    dist[next.v] = cur.totalWeight + next.totalWeight;
	                    queue.add(new Edge(next.v, dist[next.v]));
	                }
	            }
	        }
	        return dist[end];
	    }
	}

