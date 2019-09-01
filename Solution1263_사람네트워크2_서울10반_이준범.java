package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1263_사람네트워크2_서울10반_이준범 {
	
	public static long Answer;
	public static int N;
	public static int INF = 987654321;
	public static int[][] node;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Answer = INF;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			node = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					node[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && node[i][j] == 0)
						node[i][j] = INF;
				}
			}
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k)
						continue;
					for (int j = 0; j < N; j++) {
						if (j == k)
							continue;
						if (i != j && node[i][j] != 0)
							node[i][j] = Math.min(node[i][k]+node[k][j], node[i][j]);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				long sum = 0;
				for (int j = 0; j < N; j++)
					sum += node[i][j];
				if (sum < Answer)
					Answer = sum;
			}
			System.out.println("#" + test_case + " " + Answer);
		}
		
		br.close();
	}
	
}
