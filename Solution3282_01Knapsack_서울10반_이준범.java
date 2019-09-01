package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution3282_01Knapsack_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3282.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] item = new int[N+1][2];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				item[i][0] = Integer.parseInt(st.nextToken());
				item[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[][] value = new int[N+1][K+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= K; j++) {
					if (item[i][0] > j)	value[i][j] = value[i-1][j];
					else				value[i][j] = Math.max(item[i][1]+value[i-1][j-item[i][0]], value[i-1][j]);
				}
			}
			
			System.out.println("#" + test_case + " " + value[N][K]);
		}
		
		br.close();
	}
	
}
