import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * https://www.acmicpc.net/problem/1035
 * 조각 움직이기
 */
/*

*...*
.....
.....
.....
*....

6

 */


class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x; this.y = y;
	}
}

public class Main {

	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };
	
	static int result = 100;
	static boolean[][] map = new boolean[5][5];
	static ArrayList<Pair> list = new ArrayList<Pair>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 5;
		
		for( int i = 0; i < N; i++ ) {
			String temp = br.readLine();
			
			for( int j = 0; j < N; j++ ) {
				if( temp.charAt(j) == '*') {
					list.add(new Pair(i,j));
				}
				map[i][j] = false;
			}
		}		
			
		dfs(0,0);
		
		System.out.println(result);
	}
	
	static int calc_distance( int a, int b, int x, int y ) {
		return Math.abs(x - a) + Math.abs(y - b);
	}
	
	static void visited(int a, int b, boolean[][] visit) {
		for (int i = 0; i < 4; ++i) {
			int x = b + dx[i];
			int y = a + dy[i];
			
			if( x < 0 || x >= 5 || y < 0 || y >= 5) continue;
			
			if (map[y][x] != true || visit[y][x]) continue;
			
			visit[y][x] = true;
			visited(y, x, visit);
		}
	}
	
	static boolean isConn() {
		boolean[][] visit = new boolean[5][5];
		int cnt = 0;
		
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				if (map[i][j] == true && !visit[i][j]) {
					visit[i][j] = true;
					cnt++;
					if( cnt >=2 ) return false;
					visited(i, j, visit);
				}
			}
		}
	 
		if (cnt == 1) {
			return true;
		}
			
		return false;
	}
	
	
	static void dfs(int cnt, int depth ) {
		if( depth >= result ) {
			return;
		}
		
		if( cnt == list.size() ) {
			if( isConn() == true ) {
				result = Math.min(result, depth);
			}	
			return;
		}
		
		for( int i = 0; i < 5; i++ ) {
			for( int j =0; j < 5; j++ ) {
				if( map[i][j] == false ) {
					map[i][j] = true;
					dfs( cnt+1,  depth + calc_distance(i,j, list.get(cnt).x, list.get(cnt).y ) );
					map[i][j] = false;
				}
			}
		}
	}
	
}


