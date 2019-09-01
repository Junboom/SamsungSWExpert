package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

class Solution5215_햄버거다이어트_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			int[][] kfc = new int[N+1][2];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				kfc[i][0] = Integer.parseInt(st.nextToken());
				kfc[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[][] value = new int[N+1][max+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= max; j++) {
					if (kfc[i][1] > j)	value[i][j] = value[i-1][j];
					else				value[i][j] = Math.max(kfc[i][0]+value[i-1][j-kfc[i][1]], value[i-1][j]);
				}
			}
			
			System.out.println("#" + test_case + " " + value[N][max]);
		}
		
		br.close();
	}
	
}
