import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/14501
 * 퇴사 
 *
 */

/***
 5
4 10
2 9
2 3
2 2
3 100
 
 
 11
 * 
 */

public class Main {

	static int n, maxValue;
	static int[] day;
	static int[] cost;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		solve();
	}

	static void dfs(int d, int sum) {
		if (d == n) {
			maxValue = maxValue > sum ? maxValue : sum;
		} else {
			if (d + day[d] <= n)
				dfs(d + day[d], sum + cost[d]);
			if (d + 1 <= n)
				dfs(d + 1, sum);
		}
	}

	static void solve() {
		maxValue = 0;
		dfs(0, 0);
		System.out.println(maxValue);
	}

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());

		day = new int[n];
		cost = new int[n];

		for (int i = 0; i < n; i++) {
			String[] sp = br.readLine().split(" ");
			day[i] = Integer.valueOf(sp[0]);
			cost[i] = Integer.valueOf(sp[1]);
		}
	}

	static void swap(int a, int b) {
		int temp = 0;
		temp = a;
		a = b;
		b = temp;
	}

}