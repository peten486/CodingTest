import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1655
 * 가운데를 말해요
 */


/* 풀이 

2개의 PriorityQueue를 선언한다. → 각각을 minHeap, maxHeap이라고 부르겠다.
각 PriorityQueue는 작은 값, 큰 값 우선순위를 가지게 Compartor인터페이스의 메소드를 오버라이딩한다.

두 개의 PriorityQueue의 크기가 같은 경우 maxHeap에 입력된 값을 추가한다.
입력한 값이 minHeap의 최솟값보다 크다면 둘을 swap 한다.

두 개의 크기가 다른 경우 minHeap에 입력된 값을 추가한다.
입력한 값이 maxHeap의 최댓값보다 작다면 둘을 swap 한다.

maxHeap의 top에 위치한 값이 중간 값이 되게 된다.


◆  위와 같은 작업을 하게 되면 아래와 같이 값이 저장된다. (왼쪽[] -> maxHeap, 오른쪽[] -> minHeap) 
 1 입력 	▶ max[1] 			min[ ]  	→ 1 출력
 5 입력 	▶ max[1] 			min[5]   	→ 1 출력
 2 입력 	▶ max[1 2] 			min[5]  	→ 2 출력
10 입력 	▶ max[1 2] 			min[5 10]  	→ 2 출력
-99 입력 	▶ max[-99 1 2] 		min[5 10]  	→ 2 출력
 7 입력 	▶ max[-99 1 2] 		min[5 7 10] → 2 출력
 5 입력 	▶ max[-99 1 2 5] 	min[5 7 10] → 5 출력


 */

public class Main {

	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        StringBuilder sb = new StringBuilder();
	        
	        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1,o2)->o1-o2);
	        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
	        
	        
	        for( int i = 0; i < N; i++ ) {
	        	int num = Integer.parseInt(br.readLine());
	        	
	        	if(minHeap.size() == maxHeap.size()) maxHeap.offer(num); // 사이즈가 같으면 maxHeap에 넣음
	        	else minHeap.offer(num); // 아니면 minHeap에 넣음
	        	
	        	if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
	        		if(minHeap.peek() < maxHeap.peek()) {
	        			// maxHeap의 peek가 minHeap의 peek보다 큰 경우 두 값을 swap
	        			int tmp = minHeap.poll();
	        			minHeap.offer(maxHeap.poll());
	        			maxHeap.offer(tmp);
	        		}
	        	}
	        	sb.append(maxHeap.peek() + "\n");
	        }
	        System.out.println(sb);
	    }
	}

