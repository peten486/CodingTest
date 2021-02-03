
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 * 프린터
 *  
 */

public class Solution {
	static Queue<Docu> que = new LinkedList<Docu>();
	static ArrayList<Docu> arr = new ArrayList<Docu>();
	static int [] pri_count = new int[10];
	
	public static void main(String[] args) {
		int[] priorities = {2,1,3,2};
		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		int location = 2;
		int location2 = 0;
        int result = solution(priorities2, location2 );
        System.out.println(result);
    }
	
	static int solution(int[] priorities, int location) {
        int answer = 0;
        
        
        for(int i = 0; i < priorities.length; i++ ) {
        	que.add(new Docu(priorities[i], i ));
        	pri_count[ priorities[i] ]++;
        }
        
        while(!que.isEmpty()) {
        	Docu cur = que.peek();
        	if( chkPriority( cur.pri ) == true ){
        		arr.add( new Docu( cur.pri, cur.pos ) );
        		minusPriority( cur.pri );
        		que.remove();
        	} else {
        		que.add( new Docu( cur.pri, cur.pos ) );
        		que.remove();
        	}
        }
        
        /*
        for(int i = 0; i < arr.size(); i++) {
        	System.out.println("["+i+"] : pri(" + arr.get(i).pri + "), pos(" + arr.get(i).pos + ")" );
        }
        */
        
        for(int i = 0; i < arr.size(); i++) {
        	if( arr.get(i).pos == location ) {
        		answer = i + 1;
        		break;
        	}
        }
        
        return answer;
    }
	
	static boolean chkPriority(int pri) {
		for(int i = pri + 1; i <= 9; i++ ) {
			if( pri_count[i] > 0 ) {
				return false;
			}
		}
		return true;
	}
	
	static void minusPriority(int pri) {
		pri_count[pri]--;
	}
	
	static class Docu {
		int pri; // 중요도 
		int pos; // 원래 순서 
		Docu(int pri, int pos){
			this.pri = pri;
			this.pos = pos;
		}
	}
	
}
