import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/1436
 * 영화감독 숌
 */

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int start = 666;
		int i = 0;
		
		while( true ) {
			String temp = "" + (start+i);
			if( temp.contains("666")) {
				cnt++;
				if( cnt == N ) {
					System.out.println(temp);
					break;
				}
			}
			i++;
		}
		
		
	}
}

/*
1 : 666
2 : 1666
3 : 2666
4 : 3666
5 : 4666
6 : 5666
7 : 6660
8 : 6661
9 : 6662
10 : 6663
11 : 6664
12 : 6665
13 : 6666
14 : 6667
15 : 6668
16 : 6669
17 : 7666
18 : 8666
19 : 9666
20 : 10666

 
 
 */

