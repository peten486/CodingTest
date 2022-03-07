import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.acmicpc.net/problem/14503
 * 로봇 청소기  
 */

/*

11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1

57

 */


public class Main {
	static int[][] map;
	static int N,M;
	static int r,c,d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp_str = br.readLine().split(" ");
		N = Integer.valueOf(temp_str[0].trim());
		M = Integer.valueOf(temp_str[1].trim());
		
		temp_str = br.readLine().split(" ");
		r = Integer.valueOf(temp_str[0].trim());
		c = Integer.valueOf(temp_str[1].trim());
		d = Integer.valueOf(temp_str[2].trim());
		
		map = new int[N][M];
		
		for( int i = 0; i < N; i++ ) {
			String[] temp_str2 = br.readLine().split(" ");
			
			for( int j = 0; j < M; j++ ) {
				map[i][j] = Integer.valueOf(temp_str2[j].trim());
			}	
		}
		int result = 0;
		int check_4way_dire = 0;
		while( true ) {
			// 1번
			if( map[r][c] == 0 ) {
				map[r][c] = 2;
				result++;
				
				System.out.println("\n\n>>>> phase :: "+ result);
				System.out.println("r : "+r+", c : "+ c + ", d : "+ d );
				for(int i = 0; i < N; i++ ) {
					for( int j = 0; j < M; j++ ) {
						System.out.print(map[i][j]+" ");
					}
					System.out.println();
				}
				
				
			}
			if( result == 2 ) {
				System.out.println("\n\n>>>> phase :: "+ result);
				System.out.println("r : "+r+", c : "+ c + ", d : "+ d );
			}
			
			// 2-1번 
			if( checkMoving(1) == true ) {
				moveCleaner(1);
				getNextDirection();
				check_4way_dire = 0;
				continue;
			}
			else {
				// 2-2 번 
				if( check_4way_dire == 4) {
					check_4way_dire = 0;
					// 2-3 번 
					if( checkMoving(-2) == false ) {
						break;
					} else {
						moveCleaner(-2);
						continue;
					}
				}
				else {
					getNextDirection();
					//checkMoving(1);
					check_4way_dire++;
					continue;
				}
			}
			
		}
			
		System.out.println(result);
	}
	
	static int getNextDirection(){
		switch(d) {
		case 0: d=3; break;
		case 3: d=2; break;
		case 2: d=1; break;
		case 1: d=0; break;
		}
		return d;
	}
	
	static boolean checkMoving(int move_cnt) {
		if( move_cnt == 0 ) return false;
		int temp_x = 0; // 아래 간격 
		int temp_y = 0; // 오른쪽 간격 
		
		// 위 
		if( d == 0 ) {
			temp_y = (-1) * move_cnt;
		} // 오른쪽 
		else if( d == 1 ) {
			temp_x = (-1) * move_cnt;
		} // 아래쪽 
		else if( d == 2 ) {
			temp_y = move_cnt;
		} // 왼쪽 
		else if( d == 3 ) {
			temp_x = move_cnt;
		}
		
		temp_x += r;
		temp_y += c;
		System.out.println("nx : "+temp_x+", ny : "+ temp_y + ", d : "+ d );
		if( temp_x < 0 || temp_x >= N || temp_y < 0 || temp_y >= M ) {
			return false;
		} else {
			if( map[temp_x][temp_y] == 2 ) {
				return false;
			} else if( map[temp_x][temp_y] == 1 ) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean moveCleaner(int move_cnt) {
		if( move_cnt == 0 ) return false;
		int temp_x = 0; // 아래 간격 
		int temp_y = 0; // 오른쪽 간격 
		
		// 위 
		if (d == 0) {
			temp_y = (-1) * move_cnt;
		} // 오른쪽
		else if (d == 1) {
			temp_x = (-1) * move_cnt;
		} // 아래쪽
		else if( d == 2 ) {
			temp_y = move_cnt;
		} // 왼쪽  
		else if( d == 3 ) {
			temp_x = move_cnt;
		}
				
		
		temp_x += r;
		temp_y += c;
		
		if( temp_x < 0 || temp_x >= N || temp_y < 0 || temp_y >= M ) {
			return false;
		} else {
			if( map[temp_x][temp_y] == 2  ||  map[temp_x][temp_y] == 1 ) {
				return false;
			}
		}
		r = temp_x;
		c = temp_y;
		
		return true;
	}
}


