import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/60057?language=java
 * 문자열 압축
 */

/*
입출력 예 
s							/  	result
"aabbaccc"					/   7
"ababcdcdababcdcd"			/  	9
"abcabcdede"				/   8
"abcabcabcabcdededededede" 	/	14
"xababcdcdababcdcd"			/	17

 */


public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
	
		Sol1 sol = new Sol1();
		int result = sol.solution(s);
		
		System.out.println("result : "+  result );
		
		br.close();
	}	
}

class Sol1 {
	public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if(s.length() == 1 ) return 1;
        
        for( int i = 1; i < (s.length()/2)+1; i++ ) {
        
        	String str = "";
        	String temp = "";
        	int count = 1;
        	
        	for( int j = 0; j < s.length()/i; j++) {
        		if( temp.equals(s.substring(j*i, (j*i)+i))) {
        			count++;
        			continue;
        		}
        		
        		if(count > 1 ) {
        			str+=count+temp;
        			count = 1;
        		} else {
        			str+=temp;
        		}
        		
        		temp = s.substring(j*i,(j*i)+i);
        	}
        	
        	if( count > 1 ) {
        		str += count + temp;
        		count= 1;
        	} else {
        		str += temp;
        	}
        
        	if(s.length()%i != 0 ) {
        		str += s.substring(s.length()-s.length()%i,s.length());
        	}
        	
        	answer = answer > str.length() ? str.length() : answer;
         }
        
        return answer;
    }
}