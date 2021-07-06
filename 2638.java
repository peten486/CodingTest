import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.acmicpc.net/problem/2638
 * 치즈
 */
/*


8 9
0 0 0 0 0 0 0 0 0
0 0 0 1 1 0 0 0 0
0 0 0 1 1 0 1 1 0
0 0 1 1 1 1 1 1 0
0 0 1 1 1 1 1 0 0
0 0 1 1 0 1 1 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

4

8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0

 */


class Point{
	int x, y;
	Point(int x, int y){
		this.x = x; this.y = y;
	}
}

public class Main {

	static ArrayList<Point> arr_list = new ArrayList<Point>();
	static int[] dx = {-1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static int[][] map;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp_str = br.readLine().split(" ");
		N = Integer.valueOf(temp_str[0].trim());
		M = Integer.valueOf(temp_str[1].trim());
		
		map = new int[N][M];
		for( int i = 0; i < N; i++ ){
			String[] cur_line = br.readLine().split(" ");
			for( int j = 0; j < M; j++) {
				map[i][j] = cur_line[j].trim().charAt(0) - '0';
				if( map[i][j] == 1 ) {
					arr_list.add(new Point(i,j));
				}
			}
		}
		
		

		int result = 0;
		
		while(true) {
			BFS();
			boolean res = meldingTwo();
			Clear();
	/*
			System.out.println("\n\n====>map["+(result+1)+"]");
			for( int i = 0; i < N; i++) {
				for( int j = 0; j < M; j++) {
					System.out.print( map[i][j] + " " );
				}
				System.out.println();
			}
	*/
			if( res == false ) {
				break;
			} else {
				result++;
			}
		}
		
	//	System.out.print("resut : ");
		System.out.println(result);
	}
	
	static void BFS() {
		boolean[][] visit = new boolean[N][M];
		Queue<Point> q = new LinkedList<Point>();
		q.add( new Point(0,0));
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			
			for(int i = 0; i < 4; i++ ) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if( nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
				if( visit[nx][ny] ) continue;
				
				if( map[nx][ny] == 0 ) {
					q.add( new Point(nx,ny) );
					visit[nx][ny] = true;
				}
			}
		}
		
		for( int i = 0; i < N; i++ ) {
			for( int j = 0; j < M; j++ ) {
				if( visit[i][j] ) {
					map[i][j] = -1;
				}
			}
		}
		
	}
	
	static void Clear() {
		for( int i = 0; i < N; i++ ) {
			for( int j = 0; j < M; j++ ) {
				if( map[i][j] == -1 ) {
					map[i][j] = 0;
				}
			}
		}
	}
	
	static boolean meldingTwo() {
		ArrayList<Point> del_list = new ArrayList<Point>();
		boolean result = false;
		
		for( int i = 0; i < arr_list.size(); i++ ) {
			Point cur_p = arr_list.get(i);
			int nullChk = 0;
			//System.out.print("map[" + cur_p.x +"]["+ cur_p.y + "] = " );
			for( int k = 0; k < 4; k++ ) {
				int nx = cur_p.x + dx[k];
				int ny = cur_p.y + dy[k];
				
				if( nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
				if( map[nx][ny] == 1 || map[nx][ny] == 0 ) continue;
				nullChk++;
				//System.out.print( "(" + nx + ", " + ny + ")  " );
			}
			
			//System.out.println( " ==> " + nullChk );
			
			if( nullChk >= 2) {
				del_list.add(cur_p);
				result = true;
			}
		}
		
		for( int i = 0; i < del_list.size(); i++ ) {
			map[del_list.get(i).x][del_list.get(i).y] = 0;
			arr_list.remove( del_list.get(i) );
		}
		//System.out.println( "tresut :::: " + result +"\n\n\n");
		return result;
	}
	
}


