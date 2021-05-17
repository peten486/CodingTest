import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/9375
 * 패션왕 신해빈  
 *
 * ( ( type갯수 + 1) C 1 * ... ) - 1 
 */


public class Main {
	    
	static BigInteger[] fact = new BigInteger[32];
	
    public static void main(String[] args) throws IOException {
    
    	Map<String, Integer> map = new HashMap<>();
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        
        Arrays.fill(fact, BigInteger.ZERO );
      //  factorial(30);
        
        int result = 0;
        
        for( int i = 0; i < n; i++ ) {
        	map = new HashMap<>();
        	int m = Integer.valueOf(br.readLine());
        	
        	for( int j = 0; j < m; j++) {
	        	StringTokenizer st = new StringTokenizer(br.readLine());
	            String name = st.nextToken();    
	            String type = st.nextToken();
	            
	            if(map.containsKey(type) != true) {
	            	map.put(type, 1);
	            } else {
	            	int temp = map.get(type);
	            	map.remove(type);
	            	map.put(type, temp + 1 );
	            }
        	}
        	
        	int temp2 = 1;
        	Set<String> keySet = map.keySet();
        	for(String tempKey: keySet){
        		temp2 *= combination( map.get(tempKey)+1, 1 );
            }
        	
        	result = temp2 -1;
        	System.out.println(result);
        }
        
    }
    
    static int combination(int n, int r ){
    	int result = 0;
    	
    	BigInteger temp1 = factorial(n);
    	BigInteger temp2 = factorial(n-r);
    	BigInteger temp3 = factorial(r);
    	
    	BigInteger temp4 = (temp2).multiply(temp3);

    	BigInteger temp5 = (temp1).divide(temp4);
    	
    	result = Integer.valueOf(String.valueOf(temp5));
    	return result;
    }
    
    public static BigInteger factorial(int n) { 
    	if (n <= 1) return BigInteger.ONE; 
    	
    	if( fact[n] != BigInteger.ZERO ) {
    		return fact[n];
    	}
    	
    	BigInteger k = BigInteger.ONE; 
    	for (int i = 2; i <= n; i++) { 
    		k = k.multiply(BigInteger.valueOf(i)); 
    	} 
    	
    	fact[n] = k;
    	return k; 
    }

}