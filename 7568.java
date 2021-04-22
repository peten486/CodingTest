import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/*
 * https://www.acmicpc.net/problem/7568
 * 덩치 
 */

class Person {
	int x, y;
	Person( int x, int y ){ this.x = x; this.y = y; }
}

public class Solution {
	
		static ArrayList <Person> list = new ArrayList<Person>();
	
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.valueOf(br.readLine());
	        for(int i = 0; i < N; i++ ) {
	        	String str[] = br.readLine().split(" ");
	        	list.add( new Person( Integer.valueOf(str[0]), Integer.valueOf(str[1]) ));
	        }
	        
	        sol();
	    }
	    
	    public static void sol() {
	    	for(int i = 0; i < list.size(); i++ ) {
	    		int cnt = 1;
	    		for( int j = 0; j < list.size(); j++ ) {
		    		if( i == j ) continue;
	    			if( list.get(i).x < list.get(j).x 
		    			&& list.get(i).y < list.get(j).y )
		    		{
	    				cnt++;
		    		}
	    		}
	    		System.out.print(cnt + " ");
	    	}
	    }
	}

