package com.ssafy.algo;

import java.io.*;

public class Solution7287 {
	
	public static int ans, n;
	public static boolean[] exist;
	public static int[] rome = {1, 5, 10, 50};
	
	public static void rec(int before, int sum, int cnt) {
		if (cnt == n) {
			if (!exist[sum]) {
				exist[sum] = true;
				ans++;
			}
			return;
		}
		
		for (int i = before; i < 4; i++)
			rec(i, sum+rome[i], cnt+1);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7287.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = 0;
			n = Integer.parseInt(br.readLine());
			exist = new boolean[50*n+1];
			rec(0, 0, 0);
			bw.write("#" + test_case + " " + ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
