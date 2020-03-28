package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1859 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1859.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			long ans = 0;
			int n = Integer.parseInt(br.readLine());
			int[] price = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				price[i] = Integer.parseInt(st.nextToken());
			int max = 0;
			for (int i = n-1; i >= 0; i--) {
				if (price[i] < max)	ans += (max - price[i]);
				else				max = price[i];
			}
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
