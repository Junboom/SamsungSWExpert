package com.ssafy.algo;

import java.io.*;

public class Solution6901 {
	
	public static int Answer, N;
	public static int[] sticks;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6901.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			N = Integer.parseInt(br.readLine());
			sticks = new int[N];
			
			int cnt = 0;
			int[] index_max = {0, 0};
			int index = 0;
			sticks[0] = Integer.parseInt(br.readLine());
			sticks[1] = Integer.parseInt(br.readLine());
			for (int i = 2; i < N; i++) {
				sticks[i] = Integer.parseInt(br.readLine());
				if (sticks[i] < sticks[i-1] + sticks[i-2]) {
					index_max[index] = i;
					index = (index==0) ? 1 : 0;
					cnt++;
				}
			}
			if (2 <= cnt) {
				for (int i = 0; i < 2; i++)
					Answer += sticks[index_max[i]] + sticks[index_max[i]-1] + sticks[index_max[i]-2];
			}
			
			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
	}
	
}
