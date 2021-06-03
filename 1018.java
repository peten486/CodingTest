import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1018
 * 체스판 다시 칠하기
 */


public class Main {
	
		static char[] blacks = {'B','W'};
		static char[] whites = {'W','B'};
	 	
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int N = Integer.parseInt(st.nextToken());    // 정점의 개수
	        int M = Integer.parseInt(st.nextToken());    // 간선의 개수
	        
	        char[][] map = new char[N][M];
	        for( int i = 0; i < N; i++ ) {
	        	String temp = br.readLine();
	        	for( int j = 0; j < M; j++ ) {
	        		map[i][j] = temp.charAt(j);
	        	}
	        }
	        
	        // 몇번 수행할 것인가...? 
	        // ( M-8+1 ) * ( N-8+1 )  만큼하면... 개많음 
	        int temp = Integer.MAX_VALUE;
	        int result = Integer.MAX_VALUE;
	        for( int i = 0; i < (N-8+1); i++ ) {
	        	for( int j = 0; j < (M-8+1); j++ ) {
	        		temp = getReplaceCount( map, i, j);
	        		result = Math.min( temp, result );
	        		//System.out.println("result : " + temp );
	        	}
	        }
	        System.out.println(result);
	    }
	    
	    
	    public static int getReplaceCount(char[][] map, int x, int y) {
	    	int nIdx = 0;
	    	int nCount_1 = 0;
	    	int nCount_2 = 0;
	    	
	    	// white으로 시작 ,,
	    	for( int i = x; i < x+8; i++ ) {
	    		for( int j = y; j < y+8; j++) {
	    			if( map[i][j] != whites[(nIdx % 2)] ) {
	    				nCount_1++;
	    			}
	    			nIdx++;
	    		}
	    		nIdx++;
	    	}
	    	
	    	nIdx = 0;
	    	// black로 시작 
	    	for( int i = x; i < x+8; i++ ) {
	    		for( int j = y; j < y+8; j++) {
	    			if( map[i][j] != blacks[(nIdx % 2)] ) {
	    				nCount_2++;
	    			}
	    			nIdx++;
	    		}
	    		nIdx++;
	    	}
	    	
	    	return Math.min(nCount_1, nCount_2);
	    }
	    
	}

