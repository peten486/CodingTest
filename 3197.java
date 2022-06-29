import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/3197
 * 백조의 호수
 */


/* 풀이 

4 11
..XXX...X..
.X.XXX...L.
....XXX..X.
X.L..XXX...



4 11
...........
.........L.
...........
X.L........


4 4
L...
....
....
...L


 */

public class Main {

	static int r,c,ex,ey;
	static char[][] map;
	static boolean[][] check;
	static Queue<int[]> wq,sq;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		wq = new LinkedList<>();
		sq = new LinkedList<>();
		int sx = -1, sy = -1;
		
		for(int i=0; i<r; i++) {
			String line = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'L') {
					if(sx==-1 && sy==-1) {
						sx = j;
						sy = i;
					}else {
						ex = j;
						ey = i;
					}
					map[i][j] ='.';
				}
				
				if(map[i][j] == '.') {
					wq.add(new int[] {j,i});
				}
			}
		}
		
		check = new boolean[r][c];
		sq.add(new int[] {sx,sy});
		check[sy][sx] = true;
		
		int time=0;
		while(true) {
			if(move()) break;
			melting();
			time++;
			
		}
		System.out.println(time);
	}
	
	/*
	 * move : sq는 탐색 경로, q는 다음 경로 탐색할때의 시작 위치들.
	 */
	static boolean move() {
		Queue<int[]> q = new LinkedList<>();
		
		while(!sq.isEmpty()) {
			int[] p = sq.poll();
			int px = p[0], py = p[1];
			if(px == ex && py == ey) {
				return true;
			}
			
			for(int i=0; i<4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				
				if(nx <0 || ny<0 || nx>c-1 || ny>r-1 || check[ny][nx]) continue;
				
				check[ny][nx] = true;
				if(map[ny][nx] == '.') {
					sq.add(new int[] {nx,ny}); 
				}
				else if(map[ny][nx] == 'X') { // 다음 탐색지역 
					q.add(new int[] {nx,ny});
				}
			}
		}
		
		sq = q;
		
		return false;
	}
	
	/* 
	 * melting : queue wq에 넣은 것을 꺼내서 상하좌우를 보고 'X'인것을 '.'으로 변경하고 wq에 '.'으로 변경된 nx,ny좌표를 등록 
	 */
	static void melting() {
		int size = wq.size();
		for(int i=0; i<size; i++) {
			int[] p = wq.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p[0] + dx[d];
				int ny = p[1] + dy[d];
				
				if(nx <0 || ny<0 || nx>c-1 || ny>r-1) continue;
				if(map[ny][nx] == 'X') {
					map[ny][nx] = '.';
					wq.add(new int[] {nx,ny});
				}
			}
		}
	}
	
	public static void print(char[][] map) {
		
		System.out.println();
		for(int i = 0; i < r; i++) {
			System.out.println("=");
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(map[i][j]+"  ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < r; i++) {
			System.out.println("=");
		}
		System.out.println();
	}
}
		
