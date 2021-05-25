import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.acmicpc.net/problem/7562
 * 나이트의 이동
 *
 */

/***
3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1
 
5
28
0

 * 
 */

public class Main {

	
	
	static int l, test_case;
	
	static int[] dx = {-1,-2,-2,-1, 1,2,1,2};
	static int[] dy = {-2,-1,1,2, -2,-1,2,1};
	
	static int cur_x, cur_y;
	static int goal_x, goal_y;
	static int[][] map;
	static boolean[][] chk;
	static Queue<Pair> queue = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		test_case = Integer.valueOf(br.readLine());
		
				
		for( int t = 0; t < test_case; t++ ) {
			l = Integer.valueOf(br.readLine());
			
			map = new int[l][l];
			chk = new boolean[l][l];
		
			String[] sp = br.readLine().split(" ");
			cur_x = Integer.valueOf(sp[0]);
			cur_y = Integer.valueOf(sp[1]);
		
			map[cur_x][cur_y] = 1;
				
			sp = br.readLine().split(" ");
			goal_x = Integer.valueOf(sp[0]);
			goal_y = Integer.valueOf(sp[1]);

			bfs( cur_x, cur_y );
			bw.write( String.valueOf(map[goal_x][goal_y] - 1) +"\n" );
		}
		
		bw.flush();
		bw.close();
	}

	static void dfs(int x, int y ) {
		if( x == goal_x && y == goal_y ) return;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if ((nx < l && nx >= 0) && (ny < l && ny >= 0)) {
				if (nx == cur_x && ny == cur_y) {
					continue;
				}
				if (map[nx][ny] == 0 || map[nx][ny] > map[x][y] + 1) {
					map[nx][ny] = map[x][y] + 1;
					dfs(nx, ny );
				}
			}

		}
	}

	static void bfs(int x, int y) {
		if( x== goal_x && y == goal_y ) return;
		chk[x][y] = true;
		queue.add(new Pair(x,y));
		
		while( !queue.isEmpty() ) {
    		Pair cur = queue.poll();
    		
    		for(int i = 0; i < 8; i++ ) {
    			int nx = cur.x + dx[i];
    			int ny = cur.y + dy[i];
    			
    			if ((nx < l && nx >= 0) && (ny < l && ny >= 0)) {
	    			if( chk[nx][ny] == false ) {
	    				chk[nx][ny] = true;
	    				map[nx][ny] = map[cur.x][cur.y] + 1;
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