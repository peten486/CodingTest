import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2630
 * 색종이 만들기 
 */

/*

8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 0 0 1 1 0 0
1 0 0 0 1 1 1 1
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1

9
7

2
1 0
0 1


 */


public class Main {
	static int[][] map;
	static int N;
	static int blueCnt, whiteCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		blueCnt = 0;
		whiteCnt = 0;

		N = Integer.valueOf( br.readLine().trim() );
		map = new int[N][N];
		
		for( int i = 0; i < N; i++ ) {
			String[] temp_str2 = br.readLine().split(" ");
			
			for( int j = 0; j < N; j++ ) {
				map[i][j] = Integer.valueOf(temp_str2[j].trim());
			}	
		}
/*
		for( int i = 0; i < N; i++ ){
			for( int j = 0; j < N; j++ ){
				System.out.print( map[i][j]+" ");
			}
			System.out.println();
		}
*/
		divideSquare( 0, 0, N, N );
		
		//System.out.print("white cnt : ");
		System.out.println(whiteCnt);
		//System.out.print("blue cnt : ");
		System.out.println(blueCnt);
	}

	public static void divideSquare( int start_x, int start_y, int end_x, int end_y ) {

//		System.out.println( start_x +", " + start_y + " :: " + end_x + ", " + end_y );
		//return;

		if( start_x == end_x && start_y == end_y ){
			if( map[start_x][start_y] == 1 ){
				blueCnt++;
			} else {
				whiteCnt++;
			}
			return;
		} else {
		//	return;
		}

		boolean chkExist = false;
		int prev_value = map[start_x][start_y];
		for( int i = start_x; i < end_x; i++ ){
			for( int j = start_y; j <  end_y; j++ ){
				if( map[i][j] != prev_value ){
					chkExist = true;
					break;
				}
			}
		}
		//System.out.println("chkExist : " + chkExist );
		if( chkExist == true ){
			int mid_x = (int)(( end_x - start_x ) / 2) + start_x;
			int mid_y = (int)(( end_y - start_y ) / 2) + start_y;
			/*if( ( end_y - start_y ) % 2 != 0 ){
				mid_y++;
			}
			if( ( end_x - start_x ) % 2 != 0 ){
				mid_x++;
			}*/
			divideSquare( start_x, start_y, mid_x, mid_y );//
			divideSquare( mid_x, start_y, end_x, mid_y );
			divideSquare( start_x, mid_y, mid_x, end_y );
			divideSquare( mid_x, mid_y, end_x, end_y );//
		} else {
			if( prev_value == 1 ){
				blueCnt++;
			} else {
				whiteCnt++;
			}
		}
		return;
	}
}


