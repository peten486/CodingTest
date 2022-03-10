import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 * 오픈채팅방
 */

/*
입출력 예 
input
["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	

output
["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]

 */


public class Main {
	

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//String s = br.readLine();

		String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan","Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] output = {};
		
		Sol sol = new Sol();
		
		output = sol.solution(input);
		
		for(int i =0; i < output.length; i++) {
			System.out.println("output["+(i+1)+"] : "+ output[i] );
		}
		
		//br.close();
	}	
}

class Sol {
	public String[] solution(String[] record) {
        
        Map<String, String> uid_map = new HashMap<>();
        int msg_cnt = 0;
        
        for(int i = 0; i < record.length; i++ ) {
        	String[] split_record = record[i].split(" ");
        	if( split_record[0].equals("Enter") == true ) {
        		uid_map.put(split_record[1], split_record[2]);
        		msg_cnt++;
        	} else if( split_record[0].equals("Leave") == true ) {
        		msg_cnt++;
        	} else if( split_record[0].equals("Change") == true ) {
        		uid_map.put(split_record[1], split_record[2]);
        	}
        }
        
        String[] answer = PrintMsg(record, msg_cnt, uid_map);
        
        return answer;
    }
	
	
	public String[] PrintMsg(String[] record, int msg_cnt, Map<String, String> uid_map ) {
		String[] result = new String[msg_cnt];
		int cur_cnt = 0;
		for( int i = 0; i < record.length; i++ ) {
        	String[] split_record = record[i].split(" ");
        	if( split_record[0].equals("Enter") == true ) {
        		result[cur_cnt++] = uid_map.get(split_record[1]) + "님이 들어왔습니다.";
        	} else if( split_record[0].equals("Leave") == true ) {
        		result[cur_cnt++] = uid_map.get(split_record[1]) + "님이 나갔습니다.";
        	} else if( split_record[0].equals("Change") == true ) {
        	}
		}
		
		return result;
	}
}


