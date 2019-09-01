package com.ssafy.algo;

import java.io.*;

public class Solution7206_숫자게임_서울10반_이준범 {
	
	public static int ans, top;
	public static int[] stack;
	
	public static void dfs(int mul, int cnt) {
		int k = 10;
		while (true) {
			if (k > mul) {
				if (ans < cnt)
					ans = cnt;
				return;
			}
			
			int e = mul / k;
			int f = mul % k;
			int l = 10;
			while (true) {
				if (l > f)
					break;
				int g = f / l;
				int h = f % l;
				dfs(e*g*h, cnt+1);
				l *= 10;
			}
			dfs(e*f, cnt+1);
			k *= 10;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			ans = 0;
			stack = new int[100000];
			top = -1;
			int num = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			int i = 10;
			while (true) {
				if (i > num)
					break;
				int a = num / i;
				int b = num % i;
				int j = 10;
				while (true) {
					if (j > b)
						break;
					int c = b / j;
					int d = b % j;
					dfs(a*c*d, cnt+1);
					j *= 10;
				}
				dfs(a*b, cnt+1);
				i *= 10;
			}
			
			bw.write("#" + test_case + " " + ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
