import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.acmicpc.net/problem/7576
 * 토마토 
 *
 */

/***
6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1

8

 * 
 */

public class Main {

	static int result;
	static int n, m;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static int[][] map;
	static boolean[][] chk;
	static Queue<Pair> queue = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] sp = br.readLine().split(" ");
		m = Integer.valueOf(sp[0]);
		n = Integer.valueOf(sp[1]);
		
		map = new int[n][m];
		chk = new boolean[n][m];

		result = 0;
		boolean nullChk = false;
		
		for( int i = 0; i < n; i++ ) {
			sp = br.readLine().split(" ");
			for( int j = 0; j < m; j++ ) {
				map[i][j] = Integer.valueOf(sp[j]);
				if( map[i][j] == 1 ) {
					
					chk[i][j] = true;
					queue.add(new Pair(i,j));
				}
				if( map[i][j] == 0 ) {
					nullChk = true;
				}
			}
		}
		
		if( nullChk == false ) {
			System.out.println(0);
			return;
		}
		
		/*
		for( int i = 0; i < n; i++ ) {
			for( int j = 0; j < m; j++ ) {
				System.out.print ( map[i][j]+ " ");
			}
			System.out.println();
		}
		*/
		
		bfs();
		boolean existChk = false;
		for( int i =0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if( map[i][j] == 0) {
					existChk = true;
					break;
				}
			}
		}
		
		if( existChk ) {
			System.out.println(-1);
		} else {
			System.out.println( result - 1 );
		}
		
	}


	static void bfs() {
		
		while( !queue.isEmpty() ) {
    		Pair cur = queue.poll();
    		
    		for(int i = 0; i < 4; i++ ) {
    			int nx = cur.x + dx[i];
    			int ny = cur.y + dy[i];
    			if ((nx < n && nx >= 0) && (ny < m && ny >= 0)) {
    				if( map[nx][ny] == 0 && chk[nx][ny] == false ) {
    				//	System.out.println("[2] x : "+ nx + ", y : " +ny +" : " + map[nx][ny] );
	    				chk[nx][ny] = true;
	    				map[nx][ny] = map[cur.x][cur.y] + 1;
	    				result = Math.max(result, map[nx][ny] );
	    				queue.add( new Pair(nx,ny) );
	    			}
    			}	
    		}
		
    	}
	}
	
}

class Pair{
	int x;
	int y;
	public Pair(int x, int y) { this.x = x; this.y = y; }
}