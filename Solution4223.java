package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution4223 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4223.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			int ans = 987654321;
			int n = Integer.parseInt(br.readLine());
			int[][] ch = new int[n][26];
			int[] score = new int[n];
			for (int i = 0; i < n; i++) {
				int l = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < l; j++)
					ch[i][st.nextToken().charAt(0)-'A']++;
				score[i] = Integer.parseInt(br.readLine());
			}
			
			for (int i = 1; i < (1<<n); i++) {
				int[] c = new int[26];
				int tmp = 0;
				for (int k = 0; k < n; k++) {
					if (((1<<k) & i) > 0) {
						for (int j = 0; j < 26; j++)
							c[j] += ch[k][j];
						tmp += score[k];
					}
				}
				if (1 <= c[0] && 1 <= c[6] && 1 <= c[12] &&
						1 <= c[13] && 2 <= c[18] && 1 <= c[20])
					ans = (ans > tmp) ? tmp : ans;
			}
			
			bw.write("#" + test_case + " " + (ans=(ans==987654321)?-1:ans) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
