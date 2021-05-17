import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/1110
 * 더하기 사이클
 *
 */


public class Main {
	
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        
        int temp = 0;
        int cnt = 0;
        int[] nums = getDiv(n);
        int[] nums_org = getDiv(n);
        
        while(true) {
        	
        	if( ( nums_org[0] == nums[0] && nums_org[1] == nums[1]) && cnt > 0 ) {
        		break;
        	}
        	
        	temp = nums[1]+nums[0];
        	cnt++;
        	nums[1] = nums[0];
        	nums[0] = getDiv2(temp);
        	
        }
        
        System.out.println(cnt);
        
    }
    
    static int[] getDiv( int n ) {
    	int[] result = new int[2];
    	if( n > 9 ) {
    		result[0] = n % 10; // 일의 자리 
    		result[1] = n / 10; // 십의 자리 
    	}
    	else {	
    		result[0] = 0; // 일의 자리 
    		result[1] = n; // 십의 자리 
    	}
    	return result;
    }
    
    static int getDiv2( int n ) {
    	int result = 0;
    	result = n % 10;
    	// 일의 자리 반환
    	return result;
    }

}