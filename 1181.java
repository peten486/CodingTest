import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * https://www.acmicpc.net/problem/1181
 * 단어정렬 
 */



public class Main {

	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < N; i++ ) {
			String temp = br.readLine();
			if( list.contains( temp ) == false)
				list.add(temp);
		}
		
		Descending des = new Descending();
		Collections.sort(list, des );

		
		for( int i = 0; i < list.size(); i++ ) {
			System.out.println(list.get(i));
		}
		
	}
}

//내림차순
class Descending implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if( o1.length() > o2.length() ) {
			return 1;
		} else if( o2.length() > o1.length() ) {
			return -1;
		}
			
		return o1.compareTo(o2);
	}

}
