import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
 * https://www.acmicpc.net/problem/21608
 * 상어 초등학교
 */
/*

3
4 2 5 1 7
3 1 9 4 5
9 8 1 2 3
8 1 9 3 4
7 2 3 4 8
1 9 2 5 7
6 5 2 3 4
5 1 9 2 8
2 9 3 1 4

54

3
1 2 3 4 5
2 3 4 5 6
3 4 5 6 7
4 5 6 7 8
5 6 7 8 9
6 7 8 9 1
7 8 9 1 2
8 9 1 2 3
9 1 2 3 4

44

3
1 2 3 4 5
2 1 9 8 7
3 1 2 9 8
4 1 2 3 9
5 1 2 3 4
6 2 3 4 5
7 3 4 5 6
8 4 5 6 7
9 5 6 7 8
 */


class Point{
	int r, c;
	Point(int r, int c){
		this.r = r; this.c = c;
	}
}

class PointComparator implements Comparator<Point> {
	@Override
	public int compare(Point p1, Point p2) {
		if( p1.r < p2.r ){
			return -1;
		} else if( p1.r > p2.r ){
			return 1;
		} else if( p1.r == p2.r ){
			if( p1.c < p2.c ){
				return -1;
			} else if( p1.c > p2.c ){
				return 1;
			}
			return 0;
		}
		return 0;
	}
}

class Student{
	int num;
	int r, c;
	int cnt;
	int[] like_list;

	Student( int num ){
		this.num = num;
		this.r = -1;
		this.c = -1;
		this.cnt = 0;
		like_list = new int[4];
	}
	
	public void addLikeList(int n){
		like_list[cnt] = n;
		cnt++;
	}
}

public class Main {

	static int[] dx = {-1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	static Map<Integer, Student> map = new HashMap<>();
	static int[][] classRoom;
	static int N;
	public static void main(String[] args) throws IOException {
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.valueOf(br.readLine().trim());
		classRoom = new int[N][N];
		for( int i = 0; i < (N*N); i++ ){
			String[] temp_str = br.readLine().split(" ");
			int temp_num = Integer.valueOf(temp_str[0]);
			Student temp = new Student(temp_num);
			for( int j = 0; j < 4; j++ ){
				temp.addLikeList(Integer.valueOf(temp_str[j+1]));
			}

//			System.out.println("\n\n<<<<<  step "+ temp_num +"[" + i + "]  >>>>>");
			insertStudent( temp );
/*			
			for( int k = 0; k < N; k++ ){
				for( int j = 0; j < N; j++ ){
					System.out.print(classRoom[k][j]+"\t");
				}
				System.out.println();
			}
*/
		}

		for( int k = 0; k < N; k++ ){
			for( int j = 0; j < N; j++ ){
				System.out.print(classRoom[k][j]+"\t");
			}
			System.out.println();
		}


		for( int k = 0; k < N; k++ ){
			for( int j = 0; j < N; j++ ){
				result += getGrade( classRoom[k][j] );
			}
		}
	//	System.out.print("resut : ");
		System.out.println(result);
	}
	
	static void insertStudent( Student s ){
		int[][] sub_map = new int[N][N];
		ArrayList<Point> temp_list = new ArrayList<Point>();
		ArrayList<Point> temp_list2 = new ArrayList<Point>();

		for( int i = 0; i < N; i++){
			for(int j = 0; j < N; j++ ){
				sub_map[i][j] = 0;
			}
		}

		/* 1번 조건 */
		int one_cnt = 0;
		for( int i = 0; i < 4; i++ ){
			Student cur_student = map.get( s.like_list[i] );
			if( cur_student == null ) continue;
		//	if( classRoom[cur_student.r][cur_student.c] != 0) continue;
		//	System.out.println("classRoom : " + classRoom[cur_student.r][cur_student.c] );
			sub_map[cur_student.r][cur_student.c] = cur_student.num;
			one_cnt++;
			temp_list2.add( new Point(cur_student.r, cur_student.c) );
		}


		getAdjacencyCount( temp_list, temp_list2);

		if( temp_list.size() == 1){
			s.r = temp_list.get(0).r;
			s.c = temp_list.get(0).c;
			map.put(s.num, s);
			classRoom[s.r][s.c] = s.num;
			return;
		}

		/* 2번 조건 */
		temp_list2 = new ArrayList<Point>();

		if( one_cnt == 0 ){
			getNullCount(temp_list2, new ArrayList<Point>() );
		} else {
			getNullCount(temp_list2, temp_list);
		}

		if( temp_list2.size() == 1){
			s.r = temp_list2.get(0).r;
			s.c = temp_list2.get(0).c;
			map.put(s.num, s);
			classRoom[s.r][s.c] = s.num;
			return;
		}

		/* 3번 조건 */

		Collections.sort( temp_list2, new PointComparator() );

		s.r = temp_list2.get(0).r;
		s.c = temp_list2.get(0).c;
		map.put(s.num, s);
		classRoom[s.r][s.c] = s.num;
		return;
	}	

	static void getAdjacencyCount( ArrayList<Point> return_list,  ArrayList<Point> temp_list2  ){
		int MaxCnt = 0;
		int[][] sub_sub_map = new int[N][N];

/*
		for(int i = 0; i < temp_list2.size(); i++ ){
			System.out.print("num_1 : " +  classRoom[temp_list2.get(i).r][temp_list2.get(i).c] + ", ");
			System.out.print( "( " + temp_list2.get(i).r + ", " + temp_list2.get(i).c  +" ) ");
		}
		System.out.println();
*/
		for( int i = 0; i < N; i++ ){
			for( int j = 0; j < N; j++ ){
				if( classRoom[i][j] == 0)
					sub_sub_map[i][j] = 0;
				else 
					sub_sub_map[i][j] = 1;
			}
		}

		for( int i = 0; i < N; i++ ){
			for( int j = 0; j < N; j++ ){
				if( classRoom[i][j] != 0 ) continue;
				for( int k = 0; k < temp_list2.size(); k++ ){
					if( (Math.abs(i - temp_list2.get(k).r ) + Math.abs(j- temp_list2.get(k).c )) == 1){
						sub_sub_map[i][j]++;
					}
				}
			}
		}
/*
		System.out.println("\n>>>> sub_sub_map >>>>");
		for( int i = 0; i < N; i++ ){
			for( int j = 0; j < N; j++ ){
				System.out.print(sub_sub_map[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println(">>>> sub_sub_map >>>>\n");
*/
		for( int i = 0; i < N; i++ ){
			for( int j = 0; j < N; j++ ){
				MaxCnt = Math.max( MaxCnt, sub_sub_map[i][j] );
			}
		}

		for( int i = 0; i < N; i++ ){
			for( int j = 0; j < N; j++ ){
				if( MaxCnt == sub_sub_map[i][j] && classRoom[i][j] == 0 ){
					return_list.add( new Point(i,j) );
				}
			}
		}
/*
		for(int i = 0; i < return_list.size(); i++ ){
			System.out.print("num_2 : " +  classRoom[return_list.get(i).r][return_list.get(i).c] + ", ");
			System.out.print( "( " + return_list.get(i).r + ", " + return_list.get(i).c  +" ) ");
		}
		System.out.println();
*/
	}

	static void getNullCount( ArrayList<Point> return_list,  ArrayList<Point> temp_list2  ){
		int MaxCnt = 0;
		int[][] sub_sub_map = new int[N][N];

		if( temp_list2.size() > 0 ){
			for( int k = 0; k < temp_list2.size(); k++ ){
				if( classRoom[temp_list2.get(k).r][temp_list2.get(k).c] == 0)
					sub_sub_map[temp_list2.get(k).r][temp_list2.get(k).c] = getNullCountMap( classRoom, temp_list2.get(k).r, temp_list2.get(k).c );
			}
		} else {
			for( int i = 0; i < N; i++ ){
				for( int j = 0; j < N; j++ ){
					if( classRoom[i][j] == 0)
						sub_sub_map[i][j] = getNullCountMap( classRoom, i, j );
				}
			}
		}
/*
		System.out.println("\n>>>> sub_sub_map2 >>>>");
		for( int i = 0; i < N; i++ ){
			for( int j = 0; j < N; j++ ){
				System.out.print(sub_sub_map[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println(">>>> sub_sub_map2 >>>>\n");
*/
		for( int i = 0; i < N; i++ ){
			for( int j = 0; j < N; j++ ){
				MaxCnt = Math.max( MaxCnt, sub_sub_map[i][j] );
			}
		}

		for( int i = 0; i < N; i++ ){
			for( int j = 0; j < N; j++ ){
				if( MaxCnt == sub_sub_map[i][j] ){
					if( classRoom[i][j] == 0)
						return_list.add( new Point(i,j) );
				}
			}
		}

	}

	static int getNullCountMap( int[][] sub_map, int r, int c ){
		int nx = 0;
		int ny = 0;
		int count = 0;
		for( int i = 0; i < 4; i++ ){
			nx = r + dx[i];
			ny = c + dy[i];

			if( nx < 0 || ny < 0 || nx >= N || ny >= N ) continue;
			if( sub_map[nx][ny] == 0 ){
				count++;
			}
		}
		return count;
	}

	static int getGrade(int num){
		int nx = 0;
		int ny = 0;
		int grade = 0;
		int count = 0;
		Student cur_student = map.get(num);
		if( cur_student == null ) return 0;
		for( int i = 0; i < 4; i++ ){
			nx = cur_student.r + dx[i];
			ny = cur_student.c + dy[i];

			if( nx < 0 || ny < 0 || nx >= N || ny >= N ) continue;
			
			for( int j = 0; j < 4; j++){
				if( classRoom[nx][ny] == cur_student.like_list[j] ){
					count++;
				}
			}
		}
		//System.out.println( "num["+num+"] : "+ count );
		if( count == 0 ) grade = 0;
		else if( count == 1 ) grade = 1;
		else if( count == 2 ) grade = 10;
		else if( count == 3 ) grade = 100;
		else if( count == 4 ) grade = 1000;
		return grade;
	}
}


