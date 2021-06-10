import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2206
 * 벽 부수고 이동하기
 */

class Pair {
	public int x, y;
	public int cnt, bk;
	public Pair(int x,int y, int bk, int cnt) {
		this.x = x; this.y = y;
		this.cnt = cnt;
		this.bk = bk;
	}
}


public class Main {
	
		static int[] dx = { 0, 0, -1, 1 };
		static int[] dy = { -1, 1, 0, 0 };
	 	static int N, M;
	 	static int result = 1000*1000;
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());    
	        M = Integer.parseInt(st.nextToken());    
	        
	        char[][] map = new char[N+1][M+1];
	     //   boolean[][] visit = new boolean[N+1][M+1];
	        
	        for( int i = 0; i < N; i++ ) {
	        	String temp = br.readLine();
	        	for( int j = 0; j < M; j++ ) {
	        		map[i+1][j+1] = temp.charAt(j);
	        	}
	        }
	        /*
	        for( int i = 1; i <= N; i++ ) {
	        	for( int j = 1; j <= M; j++ ) {
	        		System.out.print( map[i][j] + "\t" );
	        	}
	        	System.out.println();
	        }*/
	        
	     //   dfs( map, visit, 1,1, false, 1 );
	        bfs( map, 1,1 );
	        
	        if( result == (1000*1000) ) result = -1;
	        System.out.println(result);
	    }
	    
	    public static void dfs(char[][] map, boolean[][] visit, int x, int y, boolean chk, int cnt ) {
	    	
	    	
	    	//System.out.println( cnt +" :: x = " + x + ", y = " + y + " :: " + map[x][y] );
	    	
	    	if( x == N && y == M ) {
	    		result = Math.min(result, cnt );
	    	//	System.out.println("result(temp) : " + result );
	    		return;
	    	}
	    	
	    	for( int i = 0; i < 4; i++ ) {
	    		int nx = x + dx[i];
	    		int ny = y + dy[i];
	    		
	    		if( ( nx <= N && nx >= 1 ) && ( ny <= M && ny >= 1 ) && visit[nx][ny] == false ) {
	    			if( map[nx][ny] == '0' ) {
	    				visit[nx][ny] = true;
	    				dfs(map,visit,nx,ny,chk,++cnt);
	    			} else if( chk == false ){
	    				chk = true;
	    				visit[nx][ny] = true;
	    				dfs(map,visit,nx,ny,chk,++cnt);
	    				chk = false;
	    			}
	    			visit[nx][ny] = false;
	    		} else {
	    			continue;
	    		}
	    	}
	    	return;
	    }
	    
	    public static void bfs(char[][] map, int x, int y) {
	    	
	    	boolean[][][] visit = new boolean[N+1][M+1][2];
	    	Queue<Pair> queue = new LinkedList<>();
	    	
	    	queue.add( new Pair(x,y,0,1) );
	    	visit[x][y][0] = true;
	    	visit[x][y][1] = true;
	    	
	    	while( queue.isEmpty() == false ) {
	    		Pair cur_pair = queue.poll();
	    		
	    		if( cur_pair.x == N && cur_pair.y == M ) {
	    			result = Math.min(result, cur_pair.cnt );
	    			return;
	    		}
	    		
	    		for( int i = 0; i < 4; i++ ) {
	    			int nx = cur_pair.x + dx[i];
	    			int ny = cur_pair.y + dy[i];
	    			int bk = cur_pair.bk;
	    			int cnt = cur_pair.cnt;
	    			
	    			if( ( nx <= N && nx >= 1 ) && ( ny <= M && ny >= 1 ) ) {
	    				
	    				if( map[nx][ny] == '1' ) {
	    					if( bk == 0 && visit[nx][ny][1] == false ) {
	    						visit[nx][ny][1] = true;
		    					queue.add( new Pair(nx,ny,1,cnt+1) );
		    				}
	    				} else {
	    					if( visit[nx][ny][bk] == false ) {
		    					queue.add( new Pair(nx,ny,bk,cnt+1) );
	    						visit[nx][ny][bk] = true;
		    				}
	    				}
	    				
		    		} else {
		    			continue;
		    		}
	    		}
	    		
	    	}
	    	
	    	return;
	    }
	    
	}

