package com.ssafy.algo;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6930 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6930.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			boolean[] room = new boolean[n+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < k; i++)
				room[Integer.parseInt(st.nextToken())] = true;
			
			int half = (n+1) / 2;
			while (true) {
				int idx = 0;
				for (int i = 0; i < half; i++) {
					if (room[half-i]) {
						for (int j = half; j <= n; j++) {
							if (room[j]) {
								idx = n - j;
								break;
							}
						}
						if (idx != 0) {
							for (int j = idx; j <= n; j++) {
								
							}
						}
					}
					if (room[half+i]) {
						
					}
				}
				break;
			}
			
			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
}
