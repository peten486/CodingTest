import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * https://www.acmicpc.net/problem/1149
 * RGB 거리
 */

/*

#input
3
26 40 83
49 60 57
13 89 99


#output
96

 */

public class Main {
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = 0;
			int[][] map  = new int [1001][3];
			int[][] dist = new int [1001][3];
			
			n = Integer.valueOf(br.readLine());
			
			for( int i = 1; i <= n; i++ ) {
				String[] temp = br.readLine().split(" ");
				int a = Integer.valueOf(temp[0]);
				int b = Integer.valueOf(temp[1]);
				int c = Integer.valueOf(temp[2]);
				map[i][0] = a;
				map[i][1] = b;
				map[i][2] = c;
			}
				
			dist[0][0] = dist[0][1] = dist[0][2] = map[0][0] = map[0][1] = map[0][2] = 0;

			for(int i=1; i<=n; i++){
				dist[i][0] = Math.min(dist[i-1][1], dist[i-1][2]) + map[i][0];
				dist[i][1] = Math.min(dist[i-1][0], dist[i-1][2]) + map[i][1];
				dist[i][2] = Math.min(dist[i-1][0], dist[i-1][1]) + map[i][2];
			}

			int result = Math.min(dist[n][0], Math.min(dist[n][1],dist[n][2]));
			bw.write( String.valueOf(result) );
			bw.write("\n");
			
	        bw.flush();
	        bw.close();
		}
		
		
}

