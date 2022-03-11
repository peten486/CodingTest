import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/77486
 * 다단계 칫솔 판매
 */

/*
입출력 예 
[input]
enroll
["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]

referral	
["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]

seller	
["young", "john", "tod", "emily", "mary"]	

amount
[12, 4, 2, 5, 10]

[output]
result
[360, 958, 108, 0, 450, 18, 180, 1080]


 */


public class Main {
	

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//String s = br.readLine();

		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"sam", "emily", "jaimie", "edward"};
		int[] amount = {2, 3, 5, 4};
		
		Sol sol = new Sol();
		
		int[] result = sol.solution( enroll, referral, seller, amount );
		
		for( int i= 0; i < result.length; i++ ) {
			System.out.println("result["+(i+1)+"] : "+ result[i]);
		}
		
		//br.close();
	}	
}

class Sol {
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Node top = new Node();
        Map<String, Node> map = new HashMap<String,Node>();
        
       // map.put("jaehwa", top);
        
        for( int i = 0; i < enroll.length; i++ ) {
        	if ( referral[i].equals("-") == true ) {
        		Node cur = new Node();
        		cur.Name = enroll[i];
        		cur.Parent = top;
        		InputNode(top, cur, map);
        	} else {
        		Node cur = new Node();
        		cur.Name = enroll[i];
        		cur.Parent = map.get(referral[i]);
        		InputNode(map.get(referral[i]), cur, map);
        	}
        }
        
        for( int i = 0; i < seller.length; i++) {
        	SetSeller( map.get(seller[i]), amount[i]*100);
        }
        
        for( int i = 0; i < enroll.length; i++) {
 //       	map.get(enroll[i]).Print();     	
        	answer[i] = map.get(enroll[i]).Amount;
        }
        
        
        return answer;
    }
	
	public void InputNode(Node top, Node child, Map<String, Node> map) {
		
		top.Childs.add(child);
		map.put(child.Name, child);
	}
	
	public void SetSeller(Node node, int amount) {
		Node cur_node = node;
		int minus_profit = (int)(amount * 0.1);
		int cur_node_amount = amount - minus_profit;
		int par_node_amount = minus_profit;
		
		cur_node.Amount += cur_node_amount;
		
		while( cur_node.Parent != null ) {
			cur_node = cur_node.Parent;
		
			minus_profit = (int)(par_node_amount * 0.1 );
			cur_node_amount = par_node_amount - minus_profit;
			par_node_amount = minus_profit;
			cur_node.Amount += cur_node_amount;
		}
		
	}
}

class Node {
	String Name;
	Node Parent;
	ArrayList<Node> Childs;
	int Amount;
	
	Node(){
		Amount = 0;
		Name = "";
		Parent = null;
		Childs = new ArrayList<Node>();
	}
	
	public void Print(){
		System.out.println("-------------------");
		System.out.println("Name : " + Name);
		System.out.println("Parent : " + Parent.Name);
		System.out.print("Child : [");
		
		for( int i =0; i < Childs.size(); i++ ) {
			System.out.print(Childs.get(i).Name);
			if( i != (Childs.size() -1) ) {
				System.out.print(", ");
			}
		}
		
		System.out.println("]");
		System.out.println("Amount : " + Amount);
		System.out.println("-------------------");
	}
}

